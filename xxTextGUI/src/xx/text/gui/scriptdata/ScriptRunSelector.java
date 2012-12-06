package xx.text.gui.scriptdata;

public enum ScriptRunSelector {
	THIS_SCRIPT("this script"),
	PARENT_SCRIPT("parent script"),
	ROOT_SCRIPT("root script");
	
	private String name;

	private ScriptRunSelector(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
	@Override
	public String toString() {
		return getName();
	}
	
}
