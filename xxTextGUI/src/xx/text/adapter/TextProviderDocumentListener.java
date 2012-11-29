package xx.text.adapter;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import xx.text.TextProvider;

public class TextProviderDocumentListener implements DocumentListener{

	private TextProvider data;
	
	public TextProviderDocumentListener(TextProvider data) {
		this.data = data;
	}
	
	@Override
	public void changedUpdate(DocumentEvent arg0) {
			
		try {
			data.setText(arg0.getDocument().getText(0, arg0.getDocument().getLength()));
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		try {
			data.setText(arg0.getDocument().getText(0, arg0.getDocument().getLength()));
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		try {
			data.setText(arg0.getDocument().getText(0, arg0.getDocument().getLength()));
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

}
