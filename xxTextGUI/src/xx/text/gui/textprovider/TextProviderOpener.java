package xx.text.gui.textprovider;

import xx.text.TextProvider;

public interface TextProviderOpener<T extends TextProvider> {

	void addTextProvider(T data);

}