package view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class ModificationView extends JPanel {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 3057856167490121150L;
	private JButton btnModify, btnDelete, btnBringToBack, btnBack, btnFront, btnBringToFront;
	
	
	public ModificationView() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		btnModify = new JButton("Modify");
		getBtnModify().setEnabled(false);
		add(btnModify);
		
		btnDelete = new JButton("Delete");
		getBtnDelete().setEnabled(false);
		add(btnDelete);
		
		JSeparator separator = new JSeparator();
		add(separator);
		
		btnBringToBack = new JButton("BringToBack");
		getBtnBringToBack().setEnabled(false);
		add(btnBringToBack);
		
		btnBack = new JButton("Back");
		getBtnBack().setEnabled(false);
		add(btnBack);
		
		btnFront = new JButton("Front");
		getBtnFront().setEnabled(false);
		add(btnFront);
		
		btnBringToFront = new JButton("BringToFront");
		getBtnBringToFront().setEnabled(false);
		add(btnBringToFront);
		
		
	}


	public JButton getBtnModify() {
		return btnModify;
	}


	public void setBtnModify(JButton btnModify) {
		this.btnModify = btnModify;
	}


	public JButton getBtnDelete() {
		return btnDelete;
	}


	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}


	public JButton getBtnBringToBack() {
		return btnBringToBack;
	}


	public void setBtnBringToBack(JButton btnBringToBack) {
		this.btnBringToBack = btnBringToBack;
	}


	public JButton getBtnBack() {
		return btnBack;
	}


	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}


	public JButton getBtnFront() {
		return btnFront;
	}


	public void setBtnFront(JButton btnFront) {
		this.btnFront = btnFront;
	}


	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}


	public void setBtnBringToFront(JButton btnBringToFront) {
		this.btnBringToFront = btnBringToFront;
	}
	
	
	
}
