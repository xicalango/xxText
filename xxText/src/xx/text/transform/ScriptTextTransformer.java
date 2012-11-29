package xx.text.transform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import xx.text.GeneratedTextData;
import xx.text.Script;
import xx.text.ScriptGeneratedTextData;
import xx.text.TextData;

public class ScriptTextTransformer implements TextTranformator<Script> {

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
			BufferedReader in = new BufferedReader(new StringReader(data.getText()));

			Bindings bindings = engine.createBindings();
			bindings.put("_in", in);
			bindings.put("_out", out);
			bindings.put("_text", data.getText());
			
			engine.eval(script.getText(), bindings);
			
			in.close();
			out.close();
			
			ScriptGeneratedTextData gentext = ScriptGeneratedTextData.createFromScript(script, data);
			gentext.setText(outputStringWriter.toString());
			return gentext;
			
		} catch (ScriptException | IOException e) {
			throw new TransformerException(e);
		}
		
	}

	
	
}
