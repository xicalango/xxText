package xx.text.transform;

import xx.text.GeneratedTextData;
import xx.text.TextData;

public interface TextTranformator<T> {
	GeneratedTextData<T> transform(TextData data) throws TransformerException;
}
