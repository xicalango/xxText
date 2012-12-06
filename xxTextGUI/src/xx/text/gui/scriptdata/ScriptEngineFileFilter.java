package xx.text.gui.scriptdata;

import java.io.File;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.filechooser.FileFilter;

public class ScriptEngineFileFilter extends FileFilter{

	private ScriptEngineManager sem = new ScriptEngineManager();

	@Override
	public boolean accept(File arg0) {
		if(arg0.isDirectory()) {
			return true;
		}
		
		return getScriptEngineByFile(arg0) != null;
	}

	private ScriptEngine getScriptEngineByFile(File fromFile) {
		final String fileName = fromFile.getName();
		
		int dot = fileName.lastIndexOf('.');
		String ext =fileName.substring(dot+1);
		
		ScriptEngine eng = sem.getEngineByExtension(ext);

		return eng;
	}

	@Override
	public String getDescription() {
		return "Script file";
	}


	
}
