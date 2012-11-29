package xx.text.gui.textprovider;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import xx.text.TextProvider;

public abstract class TextProviderTabContainer<T extends TextProvider> extends JPanel implements TextProviderOpener<T> {

	private class TabMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if((e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) || (e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON2))  {
				final int indexAtLocation = tabPane.indexAtLocation(e.getX(), e.getY());
				if(indexAtLocation == -1) {
					return;
				}
				
				tabPane.remove(indexAtLocation);
				
				
			} else if(e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON3) {
				
				final int indexAtLocation = tabPane.indexAtLocation(e.getX(), e.getY());
				if(indexAtLocation == -1) {
					return;
				}
				
				Component comp = tabPane.getComponentAt(indexAtLocation);
				T textProvider = textDataPanels.get(comp);
				
				String newName = JOptionPane.showInputDialog("New name:", textProvider.getName());
				
				if(newName != null) {
					textProvider.setName(newName);
					tabPane.setTitleAt(indexAtLocation, newName);
				}
				
			}
		}
		
	}
	
	private JTabbedPane tabPane;
	private JPanel buttonPanel;
	
	private Map<Component, T> textDataPanels = new HashMap<>();
	
	public TextProviderTabContainer() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600,600));
		
		setup();
	}

	private void setup() {
		tabPane = new JTabbedPane();

		tabPane.addMouseListener(new TabMouseListener());
		
		add(tabPane, BorderLayout.CENTER);
		
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JButton newTextProvider = new JButton("new");
		newTextProvider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addTextProvider(createDefaultTextProvider());	
			}});
		
		buttonPanel.add(newTextProvider);
		
		add(buttonPanel, BorderLayout.NORTH);
	}
	

	@Override
	public void addTextProvider(T data) {
		TextProviderPanel<T> tdp = createTextProviderPanel(data);
		
		tabPane.addTab(data.toString(), tdp);
		textDataPanels.put(tdp, data);
		
		tabPane.setSelectedComponent(tdp);
	}
	
	public T getCurrentTextProvider() {
		return textDataPanels.get(tabPane.getSelectedComponent());
	}
	
	protected abstract TextProviderPanel<T> createTextProviderPanel(T data);
	protected abstract T createDefaultTextProvider();
	
}
