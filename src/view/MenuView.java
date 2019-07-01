package view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class MenuView extends JPanel {

	private static final long serialVersionUID = 2059856167490121150L;
	JButton btnUndo, btnRedo, btnNew, btnSave, btnImport;
	/**
	 * Create the panel.
	 */
	public MenuView() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		btnNew = new JButton("New");
		add(btnNew);
		
		btnSave = new JButton("Save");
		add(btnSave);
		
		btnImport = new JButton("Import");
		add(btnImport);
		
		JSeparator separator = new JSeparator();
		add(separator);
		
		btnUndo = new JButton("Undo");
		add(btnUndo);
		
		btnRedo = new JButton("Redo");
		add(btnRedo);
	}
	
	public JButton getBtnUndo() {
		return this.btnUndo;
	}
	
	public JButton getBtnRedo() {
		return this.btnRedo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JButton getBtnNew() {
		return btnNew;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnImport() {
		return btnImport;
	}
	

}
