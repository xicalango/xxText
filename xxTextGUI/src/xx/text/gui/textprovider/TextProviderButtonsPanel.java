package xx.text.gui.textprovider;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class TextProviderButtonsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private TextProviderButtonListener listener;
	
	public TextProviderButtonsPanel(TextProviderButtonListener listener) {
		this.listener = listener;
		setup();
	}
	
	private void setup() {
			
		setLayout(new FlowLayout(FlowLayout.LEFT));

		JButton newTextProvider = new JButton("new");
		newTextProvider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listener.onNewClicked();	
			}});
		
		add(newTextProvider);
		
		JButton openTextProvider = new JButton("open");
		openTextProvider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleOpenFile();
			}});
		
		add(openTextProvider);
		
	}

	private void handleOpenFile() {
		
		JFileChooser jfc = new JFileChooser(".");
		listener.configureFileChooser(jfc);
		
		int result = jfc.showOpenDialog(listener.getMainComponent());
		
		if(result == JFileChooser.APPROVE_OPTION) {
			
			if(jfc.getSelectedFiles().length > 0) {
				listener.onOpenClicked(jfc.getSelectedFiles());
			} else {
				listener.onOpenClicked(jfc.getSelectedFile());
			}
		}
	}
	
}
