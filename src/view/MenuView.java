package view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class MenuView extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuView() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNew = new JButton("New");
		add(btnNew);
		
		JButton btnSave = new JButton("Save");
		add(btnSave);
		
		JButton btnImport = new JButton("Import");
		add(btnImport);
		
		JSeparator separator = new JSeparator();
		add(separator);
		
		JButton btnUndo = new JButton("Undo");
		add(btnUndo);
		
		JButton btnRedo = new JButton("Redo");
		add(btnRedo);

	}

}
