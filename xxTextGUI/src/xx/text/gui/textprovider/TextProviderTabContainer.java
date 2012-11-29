package xx.text.gui.textprovider;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import xx.text.TextData;
import xx.text.TextProvider;

public abstract class TextProviderTabContainer<T extends TextProvider> extends JTabbedPane implements TextProviderOpener<T> {

	private class TabMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if((e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) || (e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON2))  {
				final int indexAtLocation = indexAtLocation(e.getX(), e.getY());
				if(indexAtLocation == -1) {
					return;
				}
				
				remove(indexAtLocation);
				
				
			} else if(e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON3) {
				
				final int indexAtLocation = indexAtLocation(e.getX(), e.getY());
				if(indexAtLocation == -1) {
					return;
				}
				
				Component comp = getComponentAt(indexAtLocation);
				T textProvider = textDataPanels.get(comp);
				
				String newName = JOptionPane.showInputDialog("New name:", textProvider.getName());
				
				if(newName != null) {
					textProvider.setName(newName);
					setTitleAt(indexAtLocation, newName);
				}
				
			}
		}
		
	}
	
	private Map<Component, T> textDataPanels = new HashMap<>();
	
	public TextProviderTabContainer() {
		addMouseListener(new TabMouseListener());
		
		setPreferredSize(new Dimension(600,600));
	}
	
	@Override
	public void addTextProvider(T data) {
		TextProviderPanel<T> tdp = createTextProviderPanel(data);
		
		addTab(data.toString(), tdp);
		textDataPanels.put(tdp, data);
		
		setSelectedComponent(tdp);
	}
	
	public T getCurrentTextProvider() {
		return textDataPanels.get(getSelectedComponent());
	}
	
	protected abstract TextProviderPanel<T> createTextProviderPanel(T data);
	
}
