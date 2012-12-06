package xx.text;

public class DefaultScript implements Script {

	private static int scriptNumber = 0;
	
	private String language;
	private String text = "";
	private String name = generateName();

	protected String generateName() {
		return "Script #" + scriptNumber++;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public DefaultScript(String language) {
		this.language = language;
	}

	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLanguage() {
		return language;
	}

	@Override
	public String toString() {
		return getName();
	}


	@Override
	public void setLanguage(String lanugageName) {
		this.language = lanugageName;
	}

}
