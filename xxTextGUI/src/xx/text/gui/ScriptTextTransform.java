package xx.text.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import xx.text.DefaultScript;
import xx.text.DefaultTextData;
import xx.text.TextData;

public class ScriptTextTransform extends JFrame {

	
	public ScriptTextTransform() {
		
		final TextScriptSplitContainer dataPanel = new TextScriptSplitContainer();
		
		dataPanel.openTextData(new DefaultTextData());
		dataPanel.openScript(new DefaultScript("JavaScript"));
	
		add(dataPanel, BorderLayout.CENTER);
		
		pack();
		
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ScriptTextTransform();
	}
	
}
