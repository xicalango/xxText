package xx.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileTextData extends DefaultTextData {

	private File originFile;

	public FileTextData(File fromFile) throws IOException {
		originFile = fromFile;

		loadFile();

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
