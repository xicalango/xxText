package xx.text;

public class ScriptGeneratedTextData extends DefaultTextData implements GeneratedTextData<Script> {

	private Script generatorScript;
	
	public Script getGeneratorScript() {
		return generatorScript;
	}

	private ScriptGeneratedTextData() {
		
	}
	
	public static ScriptGeneratedTextData createFromScript(Script s, TextData father) 
	{
		ScriptGeneratedTextData result = new ScriptGeneratedTextData();
		result.generatorScript = s;
		result.setFather(father);
		result.setName(s.getName() + "(" + father.getName() + ") #" + System.currentTimeMillis());
		return result;
	}

	@Override
	public Script getGeneratorClass() {
		return generatorScript;
	}

}
