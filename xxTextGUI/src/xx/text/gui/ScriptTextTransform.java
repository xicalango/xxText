package xx.text.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import xx.text.DefaultScript;
import xx.text.DefaultTextData;

public class ScriptTextTransform extends JFrame {

	private static final long serialVersionUID = 1L;

	public ScriptTextTransform() {
		final TextScriptSplitContainer dataPanel = new TextScriptSplitContainer();
		
		dataPanel.openTextData(new DefaultTextData());
		dataPanel.openScript(new DefaultScript("JavaScript"));
	
		add(dataPanel, BorderLayout.CENTER);
		
		pack();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		ScriptTextTransform stt = new ScriptTextTransform();
		
		stt.setVisible(true);
	}
	
}
