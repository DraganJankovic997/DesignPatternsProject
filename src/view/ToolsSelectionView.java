package view;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JSeparator;

public class ToolsSelectionView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ToolsSelectionView() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnPoint = new JButton("Point");
		add(btnPoint);
		
		JButton btnLine = new JButton("Line");
		add(btnLine);
		
		JButton btnSquare = new JButton("Square");
		add(btnSquare);
		
		JButton btnRectangle = new JButton("Rectangle");
		add(btnRectangle);
		
		JButton btnCircle = new JButton("Circle");
		add(btnCircle);
		
		JButton btnHexagon = new JButton("Hexagon");
		add(btnHexagon);
		
		JSeparator separator = new JSeparator();
		add(separator);
		
		JButton btnSelect = new JButton("Select");
		add(btnSelect);

	}

}
