package xx.text.gui.scriptdata;

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

}
