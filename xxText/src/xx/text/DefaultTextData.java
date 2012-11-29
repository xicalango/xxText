package xx.text;

public class DefaultTextData implements TextData {

	private TextProvider father = null;
	private String text;
	private String name = "Text #" + System.currentTimeMillis();
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected void setFather(TextProvider father) {
		this.father = father;
	}
	
	@Override
	public TextProvider getFather() {
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
	
}
