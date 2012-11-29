package xx.text.gui.textprovider;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import xx.text.TextProvider;
import xx.text.adapter.TextProviderDocumentListener;

public abstract class TextProviderPanel<T extends TextProvider> extends JPanel {

	
	private static final long serialVersionUID = 1L;

	protected JTextArea textArea;
	private T textProvider;
	
	public TextProviderPanel(T textProvider) {
		this.textProvider = textProvider;
		setup();
	}

	private void setup() {
		setLayout(new BorderLayout());
		textArea = new JTextArea(textProvider.getText());
		textArea.getDocument().addDocumentListener(new TextProviderDocumentListener(textProvider));
		
		add(new JScrollPane(textArea), BorderLayout.CENTER);

		init();
	}

	protected void init() {	}

	public T getTextProvider() {
		return textProvider;
	}
	
}
