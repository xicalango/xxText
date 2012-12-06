package xx.text.gui;

import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import xx.text.DefaultTextData;
import xx.text.GeneratedTextData;
import xx.text.Script;
import xx.text.TextData;
import xx.text.gui.scriptdata.ScriptDataOpener;
import xx.text.gui.scriptdata.ScriptDataTabContainer;
import xx.text.gui.scriptdata.ScriptRunSelector;
import xx.text.gui.scriptdata.ScriptUser;
import xx.text.gui.textdata.TextDataOpener;
import xx.text.gui.textdata.TextDataTabContainer;
import xx.text.transform.ScriptTextTransformer;
import xx.text.transform.TransformerException;

public class TextScriptSplitContainer extends JSplitPane implements TextDataOpener, ScriptDataOpener, ScriptUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextDataTabContainer textDataTabContainer;
	private ScriptDataTabContainer scriptDataTabContainer;
	
	
	public TextScriptSplitContainer() {
		
		textDataTabContainer = new TextDataTabContainer();
		scriptDataTabContainer = new ScriptDataTabContainer(this);
		
		setLeftComponent(textDataTabContainer);
		setRightComponent(scriptDataTabContainer);
	}


	@Override
	public void openScript(Script script) {
		scriptDataTabContainer.openScript(script);
	}


	@Override
	public void openTextData(TextData textData) {
		textDataTabContainer.openTextData(textData);
	}


	@Override
	public void useScript(Script s, ScriptRunSelector runSelector) {
		try {
			ScriptTextTransformer stt = new ScriptTextTransformer(s);
			
			TextData currentTextProvider = textDataTabContainer.getCurrentTextProvider();
			
			if( currentTextProvider == null ) {
				currentTextProvider = new DefaultTextData(); 
			}
			
			switch(runSelector) {
			case THIS_TEXT:
				break;
			case PARENT_TEXT:
				if(currentTextProvider.getParent() != null) {
					currentTextProvider = currentTextProvider.getParent();
				}
				break;
			case ROOT_TEXT: {
					TextData startTextData = currentTextProvider;
				
					while(currentTextProvider.getParent() != null && currentTextProvider.getParent() != startTextData) {
						currentTextProvider = currentTextProvider.getParent();
					}
					break;
				}
			}
			
			final GeneratedTextData<Script> generatedText = stt.transform( currentTextProvider );
			
			textDataTabContainer.addTextProvider(generatedText);
		} catch (TransformerException e) {
			e.printStackTrace();
			
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	
	
}
