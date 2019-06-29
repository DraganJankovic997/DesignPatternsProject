package view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class ModificationView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ModificationView() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnModify = new JButton("Modify");
		add(btnModify);
		
		JButton btnDelete = new JButton("Delete");
		add(btnDelete);
		
		JSeparator separator = new JSeparator();
		add(separator);
		
		JButton btnBringtoback = new JButton("BringToBack");
		add(btnBringtoback);
		
		JButton btnBack = new JButton("Back");
		add(btnBack);
		
		JButton btnFront = new JButton("Front");
		add(btnFront);
		
		JButton btnBringtofront = new JButton("BringToFront");
		add(btnBringtofront);

	}

}
