package xx.text.gui.scriptdata;

public enum ScriptRunSelector {
	THIS_TEXT("this text"),
	PARENT_TEXT("parent text"),
	ROOT_TEXT("root text");
	
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
