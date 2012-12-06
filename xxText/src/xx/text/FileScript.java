package xx.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class FileScript extends DefaultScript {

	private File originFile;

	public FileScript(File fromFile) throws IOException {
		super(null);
		originFile = fromFile;
		
		setLanguageFromFile(fromFile);

		loadFile();

	}

	private void setLanguageFromFile(File fromFile) {
		final String fileName = fromFile.getName();
		
		int dot = fileName.lastIndexOf('.');
		String ext =fileName.substring(dot+1);
		
		ScriptEngine eng = new ScriptEngineManager().getEngineByExtension(ext);
		if(eng != null) {
			setLanguage(eng.getFactory().getEngineName());
		} else {
			throw new RuntimeException("Unknown extension: " + ext);
		}
	}
	
	@Override
	protected String generateName() {
		if(originFile == null) {
			return null; 
		} else {
			return originFile.getName();
		}
	}

	private void loadFile() throws IOException {

		StringBuilder sb = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(originFile))) {

			String line = null;

			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

		}
		
		setText(sb.toString());
		
		setName(originFile.getName());
	}
	
}
