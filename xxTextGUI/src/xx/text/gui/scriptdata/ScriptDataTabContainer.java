package xx.text.gui.scriptdata;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import xx.text.DefaultScript;
import xx.text.FileScript;
import xx.text.FileTextData;
import xx.text.Script;
import xx.text.gui.textprovider.TextProviderPanel;
import xx.text.gui.textprovider.TextProviderTabContainer;

public class ScriptDataTabContainer extends TextProviderTabContainer<Script> implements ScriptDataOpener {

	private ScriptUser scriptUser;
	
	public ScriptDataTabContainer(ScriptUser scriptUser) {
		super();
		this.scriptUser = scriptUser;
	}

	@Override
	public void openScript(Script script) {
		addTextProvider(script);
	}

	@Override
	protected TextProviderPanel<Script> createTextProviderPanel(Script data) {
		return new ScriptDataPanel(data,scriptUser);
	}

	@Override
	protected Script createDefaultTextProvider() {
		final Script currentTextProvider = getCurrentTextProvider();
		
		String name = currentTextProvider == null ? "ECMAScript" : currentTextProvider.getLanguage();
		
		return new DefaultScript(name);
	}

	@Override
	protected Script loadTextProvider(File f) throws IOException {
		return new FileScript(f);
	}
	
	@Override
	public void configureFileChooser(JFileChooser chooser) {
		chooser.setFileFilter(new ScriptEngineFileFilter());
	}

}
