package xx.text.transform;

import xx.text.GeneratedTextData;
import xx.text.Scriptable;

public interface Tranformator<S extends Scriptable, T> {
	GeneratedTextData<T> transform(S data) throws TransformerException;
}
