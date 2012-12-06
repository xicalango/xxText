package xx.text.gui.scriptdata;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import xx.text.DefaultScript;
import xx.text.Script;
import xx.text.gui.textprovider.TextProviderPanel;

public class ScriptDataPanel extends TextProviderPanel<Script> {
	
	private static final long serialVersionUID = 1L;
	
	
	private JPanel optionsPanel;
	private JComboBox<String> languagesComboBox;
	private JButton useButton;
	private JComboBox<ScriptRunSelector> useOnComboBox;
	
	private ScriptUser scriptUser;
	
	public ScriptDataPanel(ScriptUser scriptUser) {
		super(new DefaultScript("ECMAScript"));
		
		this.scriptUser = scriptUser;
	}

	public ScriptDataPanel(Script textProvider, ScriptUser scriptUser) {
		super(textProvider);
		
		this.scriptUser = scriptUser;
	}

	@Override
	protected void init() {
		optionsPanel = new JPanel( new FlowLayout(FlowLayout.LEFT) );
		
		
		languagesComboBox = new JComboBox<>(new ScriptLanguagesComboBoxModel());
		
		languagesComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getTextProvider().setLanguage((String) languagesComboBox.getSelectedItem());
			}});
		
		languagesComboBox.setSelectedItem(getTextProvider().getLanguage());
		
		
		useButton = new JButton("Use script");
		useButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scriptUser.useScript(getTextProvider(), (ScriptRunSelector) useOnComboBox.getSelectedItem());
			}});
		
		
		
		useOnComboBox = new JComboBox<>(ScriptRunSelector.values());
		useOnComboBox.setSelectedItem(ScriptRunSelector.THIS_TEXT);
		
		
		optionsPanel.add(useButton);
		optionsPanel.add(new JLabel(" on "));
		optionsPanel.add(useOnComboBox);
		optionsPanel.add(new JLabel(" as "));
		optionsPanel.add(languagesComboBox);
		
		
		add(optionsPanel, BorderLayout.NORTH);
		
		
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Monospaced",Font.PLAIN,15));
	}
	
}
