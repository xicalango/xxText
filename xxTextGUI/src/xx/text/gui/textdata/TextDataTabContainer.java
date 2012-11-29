package xx.text.gui.textdata;

import xx.text.TextData;
import xx.text.gui.textprovider.TextProviderPanel;
import xx.text.gui.textprovider.TextProviderTabContainer;

public class TextDataTabContainer extends TextProviderTabContainer<TextData> implements TextDataOpener {

	@Override
	public void openTextData(TextData textData) {
		addTextProvider(textData);
	}

	@Override
	protected TextProviderPanel<TextData> createTextProviderPanel(TextData data) {
		return new TextDataPanel(data);
	}

	
}
