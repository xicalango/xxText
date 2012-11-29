package xx.text.gui.scriptdata;

import xx.text.DefaultScript;
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

}
