package xx.text.transform;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import xx.text.GeneratedTextData;
import xx.text.Script;
import xx.text.ScriptGeneratedTextData;
import xx.text.TextData;

public class ScriptTextTransformer implements Tranformator<TextData, Script> {

	private Script script;
	private ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
	private ScriptEngine engine;
	
	public Script getScript() {
		return script;
	}

	public void setScript(Script script) {
		this.script = script;
		
		engine = scriptEngineManager.getEngineByName(script.getLanguage());
	}

	
	public ScriptTextTransformer(Script script) {
		setScript(script);
	}

	@Override
	public GeneratedTextData<Script> transform(TextData data) throws TransformerException {
		
		try {
			
			StringWriter outputStringWriter = new StringWriter();
			PrintWriter out = new PrintWriter(outputStringWriter);

			Bindings bindings = engine.createBindings();
			data.putBindings(bindings);
			bindings.put("_out", out);
			
			engine.eval(script.getText(), bindings);
			
			out.close();
			
			ScriptGeneratedTextData gentext = ScriptGeneratedTextData.createFromScript(script, data);
			gentext.setText(outputStringWriter.toString());
			return gentext;
			
		} catch (ScriptException e) {
			throw new TransformerException(e);
		}
		
	}

	
	
}
