package xx.text.gui.textdata;

import xx.text.DefaultTextData;
import xx.text.TextData;
import xx.text.gui.textprovider.TextProviderPanel;

public class TextDataPanel extends TextProviderPanel<TextData> {

	private static final long serialVersionUID = 1L;
	
	public TextDataPanel() {
		super(new DefaultTextData());
	}

	public TextDataPanel(TextData textProvider) {
		super(textProvider);
	}
	
	
}
