package xx.text.gui.textprovider;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;

public interface TextProviderButtonListener {
	
	void onNewClicked();
	
	void onOpenClicked(File selectedFile);
	void onOpenClicked(File[] selectedFiles);
	
	void configureFileChooser(JFileChooser chooser);
	
	Component getMainComponent();
}
