package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.circle.Circle;
import shapes.point.Point;
import shapes.rectangle.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogCircle extends JDialog {

	private static final long serialVersionUID = 5652494721656403879L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfX;
	private JTextField tfY;
	private JTextField tfR;
	private Color outerColor, innerColor;
	private JButton btnOuterColor, btnInnerColor;
	private Circle oldCircle, newCircle;
	private boolean updated = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogCircle dialog = new DialogCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogCircle() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenterPointX = new JLabel("Center point X :");
			GridBagConstraints gbc_lblCenterPointX = new GridBagConstraints();
			gbc_lblCenterPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterPointX.gridx = 1;
			gbc_lblCenterPointX.gridy = 1;
			contentPanel.add(lblCenterPointX, gbc_lblCenterPointX);
		}
		{
			tfX = new JTextField();
			GridBagConstraints gbc_tfX = new GridBagConstraints();
			gbc_tfX.insets = new Insets(0, 0, 5, 0);
			gbc_tfX.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfX.gridx = 3;
			gbc_tfX.gridy = 1;
			contentPanel.add(tfX, gbc_tfX);
			tfX.setColumns(10);
		}
		{
			JLabel lblCenterPointY = new JLabel("Center point Y :");
			GridBagConstraints gbc_lblCenterPointY = new GridBagConstraints();
			gbc_lblCenterPointY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterPointY.gridx = 1;
			gbc_lblCenterPointY.gridy = 2;
			contentPanel.add(lblCenterPointY, gbc_lblCenterPointY);
		}
		{
			tfY = new JTextField();
			tfY.setText("");
			GridBagConstraints gbc_tfY = new GridBagConstraints();
			gbc_tfY.insets = new Insets(0, 0, 5, 0);
			gbc_tfY.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfY.gridx = 3;
			gbc_tfY.gridy = 2;
			contentPanel.add(tfY, gbc_tfY);
			tfY.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius :");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 3;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			tfR = new JTextField();
			GridBagConstraints gbc_tfR = new GridBagConstraints();
			gbc_tfR.insets = new Insets(0, 0, 5, 0);
			gbc_tfR.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfR.gridx = 3;
			gbc_tfR.gridy = 3;
			contentPanel.add(tfR, gbc_tfR);
			tfR.setColumns(10);
		}
		{
			JLabel lblOuterColor = new JLabel("Outer color :");
			GridBagConstraints gbc_lblOuterColor = new GridBagConstraints();
			gbc_lblOuterColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblOuterColor.gridx = 1;
			gbc_lblOuterColor.gridy = 5;
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
			gbc_btnOuterColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnOuterColor.gridx = 3;
			gbc_btnOuterColor.gridy = 5;
			contentPanel.add(btnOuterColor, gbc_btnOuterColor);
		}
		{
			JLabel lblInnerColor = new JLabel("Inner color :");
			GridBagConstraints gbc_lblInnerColor = new GridBagConstraints();
			gbc_lblInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblInnerColor.gridx = 1;
			gbc_lblInnerColor.gridy = 6;
			contentPanel.add(lblInnerColor, gbc_lblInnerColor);
		}
		{
			btnInnerColor = new JButton("Inner color");
			btnInnerColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color t= JColorChooser.showDialog(null, "Choose inner color", innerColor);
					if(t!=null){
						innerColor=t;
						btnInnerColor.setBackground(innerColor);
					}
				}
			});
			GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
			gbc_btnInnerColor.gridx = 3;
			gbc_btnInnerColor.gridy = 6;
			contentPanel.add(btnInnerColor, gbc_btnInnerColor);
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
							Point newCP = new Point(Integer.parseInt(tfX.getText()), Integer.parseInt(tfY.getText()));
							int newRadius = Integer.parseInt(tfR.getText());
							newCircle = new Circle(newCP, newRadius, outerColor, innerColor);
							newCircle.setSelected(true);
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
	
	public void setCircle(Circle c) {
		this.oldCircle = c;
		this.outerColor = c.getColor();
		this.innerColor = c.getInnerColor();
		this.btnOuterColor.setBackground(outerColor);
		this.btnInnerColor.setBackground(innerColor);
		this.tfX.setText(String.valueOf(c.getCenterPoint().getX()));
		this.tfY.setText(String.valueOf(c.getCenterPoint().getY()));
		this.tfR.setText(String.valueOf(c.getRadius()));	
	}
	public Circle getCircle() {
		return newCircle;
	}
	public boolean getUpdated() {
		return updated;
	}

}
