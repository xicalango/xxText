package xx.text;

import java.io.BufferedReader;
import java.io.StringReader;

import javax.script.Bindings;

public class DefaultTextData implements TextData {

	private static int textNumber = 0;
	
	private TextData father = null;
	private String text;
	private String name = generateName();
	
	protected String generateName() {
		return "Text #" + textNumber++;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected void setFather(TextData father) {
		this.father = father;
	}
	
	@Override
	public TextData getParent() {
		return father;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	public DefaultTextData() {
		this("");
	}

	public DefaultTextData(String text) {
		super();
		this.text = text;
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public void putBindings(Bindings bindings) {
		BufferedReader in = new BufferedReader(new StringReader(getText()));
		bindings.put("_in", in);
		bindings.put("_text", getText());
		bindings.put("_lines", getText().split("\n"));
	}
	
}
