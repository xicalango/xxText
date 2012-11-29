package xx.text.gui.scriptdata;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.swing.DefaultComboBoxModel;

public class ScriptLanguagesComboBoxModel extends DefaultComboBoxModel<String> {

	public ScriptLanguagesComboBoxModel() {
		ScriptEngineManager sem = new ScriptEngineManager();
		
		for(ScriptEngineFactory sefs : sem.getEngineFactories()) {
			addElement(sefs.getLanguageName());
		}
		
	}
	
	
}
