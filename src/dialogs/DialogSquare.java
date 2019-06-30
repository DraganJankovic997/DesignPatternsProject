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
import shapes.square.Square;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogSquare extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfX;
	private JTextField tfY;
	private JTextField tfW;
	private JButton btnOuterColor, btnInnerColor;
	private Square oldSquare, newSquare;
	private Color outerColor, innerColor;
	private boolean updated = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogSquare dialog = new DialogSquare();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogSquare() {
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
			JLabel lblUpperLeftPoint = new JLabel("Upper Left point X :");
			GridBagConstraints gbc_lblUpperLeftPoint = new GridBagConstraints();
			gbc_lblUpperLeftPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeftPoint.gridx = 1;
			gbc_lblUpperLeftPoint.gridy = 1;
			contentPanel.add(lblUpperLeftPoint, gbc_lblUpperLeftPoint);
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
			JLabel lblUpperLeftPoint_1 = new JLabel("Upper Left point Y:");
			GridBagConstraints gbc_lblUpperLeftPoint_1 = new GridBagConstraints();
			gbc_lblUpperLeftPoint_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeftPoint_1.gridx = 1;
			gbc_lblUpperLeftPoint_1.gridy = 2;
			contentPanel.add(lblUpperLeftPoint_1, gbc_lblUpperLeftPoint_1);
		}
		{
			tfY = new JTextField();
			GridBagConstraints gbc_tfY = new GridBagConstraints();
			gbc_tfY.insets = new Insets(0, 0, 5, 0);
			gbc_tfY.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfY.gridx = 3;
			gbc_tfY.gridy = 2;
			contentPanel.add(tfY, gbc_tfY);
			tfY.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width :");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 1;
			gbc_lblWidth.gridy = 3;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			tfW = new JTextField();
			tfW.setText("");
			GridBagConstraints gbc_tfW = new GridBagConstraints();
			gbc_tfW.insets = new Insets(0, 0, 5, 0);
			gbc_tfW.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfW.gridx = 3;
			gbc_tfW.gridy = 3;
			contentPanel.add(tfW, gbc_tfW);
			tfW.setColumns(10);
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
							Point newUL = new Point(Integer.parseInt(tfX.getText()), Integer.parseInt(tfY.getText()));
							int newWidth = Integer.parseInt(tfW.getText());
							newSquare = new Square(newUL, newWidth, outerColor, innerColor);
							newSquare.setSelected(true);
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
	
	public void setSquare(Square sq) {
		this.oldSquare = sq;
		this.outerColor = sq.getColor();
		this.innerColor = sq.getInnerColor();
		this.btnOuterColor.setBackground(outerColor);
		this.btnInnerColor.setBackground(innerColor);
		this.tfX.setText(String.valueOf(sq.getUpperLeftPoint().getX()));
		this.tfY.setText(String.valueOf(sq.getUpperLeftPoint().getY()));
		this.tfW.setText(String.valueOf(sq.getWidth()));
	}
	
	public Square getSquare() {
		return newSquare;
	}
	
	public boolean getUpdated() {
		return updated;
	}

}
