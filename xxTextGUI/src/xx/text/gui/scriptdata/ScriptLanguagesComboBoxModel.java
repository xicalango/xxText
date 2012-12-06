package xx.text.gui.scriptdata;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.swing.DefaultComboBoxModel;

public class ScriptLanguagesComboBoxModel extends DefaultComboBoxModel<String> {

	private static final long serialVersionUID = 1L;

	public ScriptLanguagesComboBoxModel() {
		ScriptEngineManager sem = new ScriptEngineManager();
		
		for(ScriptEngineFactory sefs : sem.getEngineFactories()) {
			addElement(sefs.getLanguageName());
		}
		
	}
	
	
}
