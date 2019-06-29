package view;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JSeparator;

public class ToolsSelectionView extends JPanel {

	/**
	 * Create the panel.
	 */
	private JButton btnPoint, btnLine, btnSquare, btnRectangle, btnCircle, btnHexagon, btnSelect;
	
	public ToolsSelectionView() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		btnPoint = new JButton("Point");
		add(btnPoint);
		
		btnLine = new JButton("Line");
		add(btnLine);
		
		btnSquare = new JButton("Square");
		add(btnSquare);
		
		btnRectangle = new JButton("Rectangle");
		add(btnRectangle);
		
		btnCircle = new JButton("Circle");
		add(btnCircle);
		
		btnHexagon = new JButton("Hexagon");
		add(btnHexagon);
		
		JSeparator separator = new JSeparator();
		add(separator);
		
		btnSelect = new JButton("Select");
		add(btnSelect);

	}

	public JButton getBtnPoint() {
		return btnPoint;
	}

	public void setBtnPoint(JButton btnPoint) {
		this.btnPoint = btnPoint;
	}

	public JButton getBtnLine() {
		return btnLine;
	}

	public void setBtnLine(JButton btnLine) {
		this.btnLine = btnLine;
	}

	public JButton getBtnSquare() {
		return btnSquare;
	}

	public void setBtnSquare(JButton btnSquare) {
		this.btnSquare = btnSquare;
	}

	public JButton getBtnRectangle() {
		return btnRectangle;
	}

	public void setBtnRectangle(JButton btnRectangle) {
		this.btnRectangle = btnRectangle;
	}

	public JButton getBtnCircle() {
		return btnCircle;
	}

	public void setBtnCircle(JButton btnCircle) {
		this.btnCircle = btnCircle;
	}

	public JButton getBtnHexagon() {
		return btnHexagon;
	}

	public void setBtnHexagon(JButton btnHexagon) {
		this.btnHexagon = btnHexagon;
	}

	public JButton getBtnSelect() {
		return btnSelect;
	}

	public void setBtnSelect(JButton btnSelect) {
		this.btnSelect = btnSelect;
	}
	
	
	

}
