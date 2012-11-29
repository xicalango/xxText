package xx.text.tests.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import xx.text.DefaultTextData;
import xx.text.Script;
import xx.text.ScriptGeneratedTextData;
import xx.text.TextData;
import xx.text.TextProvider;
import xx.text.transform.ScriptTextTransformer;
import xx.text.transform.TransformerException;

public class ScriptTextTransformerTest {

	@Test
	public void testTransform_ValidInput_ValidOutput() throws TransformerException {
		
		Script testScript = new xx.text.DefaultScript("JavaScript");
		testScript.setText("_out.print(_text);");
		
		TextData textData = new DefaultTextData("test");
		
		ScriptTextTransformer tt = new ScriptTextTransformer(testScript);
		
		TextProvider result = tt.transform(textData);
		
		assertEquals(result.getClass(), ScriptGeneratedTextData.class);
		assertEquals("test", result.getText());
		
		
		
	}

}
