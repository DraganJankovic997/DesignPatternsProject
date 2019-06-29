package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Dimension;

public class LogView extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTextPane textPane;
	
	public LogView() {
		setMinimumSize(new Dimension(10, 100));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(23, 100));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		textPane = new JTextPane();
		textPane.setMinimumSize(new Dimension(7, 100));
		scrollPane.setViewportView(textPane);
		textPane.setText("");
		textPane.setEditable(false);

	}

}
