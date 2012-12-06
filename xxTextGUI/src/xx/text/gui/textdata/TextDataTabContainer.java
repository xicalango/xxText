package xx.text.gui.textdata;

import java.io.File;
import java.io.IOException;

import xx.text.DefaultTextData;
import xx.text.FileTextData;
import xx.text.TextData;
import xx.text.gui.textprovider.TextProviderPanel;
import xx.text.gui.textprovider.TextProviderTabContainer;

public class TextDataTabContainer extends TextProviderTabContainer<TextData> implements TextDataOpener {

	private static final long serialVersionUID = 1L;

	@Override
	public void openTextData(TextData textData) {
		addTextProvider(textData);
	}

	@Override
	protected TextProviderPanel<TextData> createTextProviderPanel(TextData data) {
		return new TextDataPanel(data);
	}

	@Override
	protected TextData createDefaultTextProvider() {
		return new DefaultTextData();
	}

	@Override
	protected TextData loadTextProvider(File f) throws IOException {
		return new FileTextData(f);
	}

	
}
