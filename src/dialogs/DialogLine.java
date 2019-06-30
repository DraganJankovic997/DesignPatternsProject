package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.line.Line;
import shapes.point.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField startX;
	private JTextField startY;
	private JTextField endX;
	private JTextField endY;
	private Color outerColor;
	private JButton btnOuterColor;
	private Line oldLine, newLine;
	private boolean updated = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogLine dialog = new DialogLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogLine() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartingPointX = new JLabel("Starting point X :");
			GridBagConstraints gbc_lblStartingPointX = new GridBagConstraints();
			gbc_lblStartingPointX.anchor = GridBagConstraints.EAST;
			gbc_lblStartingPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartingPointX.gridx = 1;
			gbc_lblStartingPointX.gridy = 1;
			contentPanel.add(lblStartingPointX, gbc_lblStartingPointX);
		}
		{
			startX = new JTextField();
			GridBagConstraints gbc_startX = new GridBagConstraints();
			gbc_startX.insets = new Insets(0, 0, 5, 0);
			gbc_startX.fill = GridBagConstraints.HORIZONTAL;
			gbc_startX.gridx = 2;
			gbc_startX.gridy = 1;
			contentPanel.add(startX, gbc_startX);
			startX.setColumns(10);
		}
		{
			JLabel lblStartingPointY = new JLabel("Starting point Y :");
			GridBagConstraints gbc_lblStartingPointY = new GridBagConstraints();
			gbc_lblStartingPointY.anchor = GridBagConstraints.EAST;
			gbc_lblStartingPointY.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartingPointY.gridx = 1;
			gbc_lblStartingPointY.gridy = 2;
			contentPanel.add(lblStartingPointY, gbc_lblStartingPointY);
		}
		{
			startY = new JTextField();
			GridBagConstraints gbc_startY = new GridBagConstraints();
			gbc_startY.insets = new Insets(0, 0, 5, 0);
			gbc_startY.fill = GridBagConstraints.HORIZONTAL;
			gbc_startY.gridx = 2;
			gbc_startY.gridy = 2;
			contentPanel.add(startY, gbc_startY);
			startY.setColumns(10);
		}
		{
			JLabel lblEndPointX = new JLabel("End point X :");
			GridBagConstraints gbc_lblEndPointX = new GridBagConstraints();
			gbc_lblEndPointX.anchor = GridBagConstraints.EAST;
			gbc_lblEndPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPointX.gridx = 1;
			gbc_lblEndPointX.gridy = 4;
			contentPanel.add(lblEndPointX, gbc_lblEndPointX);
		}
		{
			endX = new JTextField();
			GridBagConstraints gbc_endX = new GridBagConstraints();
			gbc_endX.insets = new Insets(0, 0, 5, 0);
			gbc_endX.fill = GridBagConstraints.HORIZONTAL;
			gbc_endX.gridx = 2;
			gbc_endX.gridy = 4;
			contentPanel.add(endX, gbc_endX);
			endX.setColumns(10);
		}
		{
			JLabel lblEndPointY = new JLabel("End point Y :");
			GridBagConstraints gbc_lblEndPointY = new GridBagConstraints();
			gbc_lblEndPointY.anchor = GridBagConstraints.EAST;
			gbc_lblEndPointY.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPointY.gridx = 1;
			gbc_lblEndPointY.gridy = 5;
			contentPanel.add(lblEndPointY, gbc_lblEndPointY);
		}
		{
			endY = new JTextField();
			GridBagConstraints gbc_endY = new GridBagConstraints();
			gbc_endY.insets = new Insets(0, 0, 5, 0);
			gbc_endY.fill = GridBagConstraints.HORIZONTAL;
			gbc_endY.gridx = 2;
			gbc_endY.gridy = 5;
			contentPanel.add(endY, gbc_endY);
			endY.setColumns(10);
		}
		{
			JLabel lblOuterColor = new JLabel("Outer color :");
			GridBagConstraints gbc_lblOuterColor = new GridBagConstraints();
			gbc_lblOuterColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblOuterColor.gridx = 1;
			gbc_lblOuterColor.gridy = 7;
			contentPanel.add(lblOuterColor, gbc_lblOuterColor);
		}
		{
			btnOuterColor = new JButton("Outer color");
			btnOuterColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color t= JColorChooser.showDialog(null, "Choose outer color", outerColor);
					if(t!=null){
						outerColor=t;
						btnOuterColor.setBackground(outerColor);
					}
				}
			});
			GridBagConstraints gbc_btnOuterColor = new GridBagConstraints();
			gbc_btnOuterColor.gridx = 2;
			gbc_btnOuterColor.gridy = 7;
			contentPanel.add(btnOuterColor, gbc_btnOuterColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Point newSP = new Point(Integer.parseInt(startX.getText()), Integer.parseInt(startY.getText()));
							Point newEP = new Point(Integer.parseInt(endX.getText()), Integer.parseInt(endY.getText()));
							newLine = new Line(newSP, newEP, outerColor);
							newLine.setSelected(true);
							updated = true;
							setVisible(false);
							dispose();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Please enter a valid Integer.");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void setLine(Line ol) {
		this.oldLine = ol;
		this.outerColor = ol.getColor();
		this.btnOuterColor.setBackground(outerColor);
		this.startX.setText(String.valueOf(ol.getStartPoint().getX()));
		this.startY.setText(String.valueOf(ol.getStartPoint().getY()));
		this.endX.setText(String.valueOf(ol.getEndPoint().getX()));
		this.endY.setText(String.valueOf(ol.getEndPoint().getY()));
	}
	
	public Line getLine() {
		return this.newLine;
	}
	
	public boolean getUpdated() {
		return this.updated;
	}

}
