package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.point.Point;
import shapes.square.Square;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SquareDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldWidth;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private Color innerColor, outerColor;
	private Square sq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SquareDialog dialog = new SquareDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SquareDialog() {
		setBounds(100, 100, 450, 300);
		setTitle("Square dialog");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblSquareWidth = new JLabel("Square width:");
			GridBagConstraints gbc_lblSquareWidth = new GridBagConstraints();
			gbc_lblSquareWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblSquareWidth.anchor = GridBagConstraints.EAST;
			gbc_lblSquareWidth.gridx = 1;
			gbc_lblSquareWidth.gridy = 1;
			contentPanel.add(lblSquareWidth, gbc_lblSquareWidth);
		}
		{
			textFieldWidth = new JTextField();
			GridBagConstraints gbc_textFieldWidth = new GridBagConstraints();
			gbc_textFieldWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldWidth.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldWidth.anchor = GridBagConstraints.WEST;
			gbc_textFieldWidth.gridx = 2;
			gbc_textFieldWidth.gridy = 1;
			contentPanel.add(textFieldWidth, gbc_textFieldWidth);
			textFieldWidth.setColumns(20);
		}
		{
			JLabel lblX = new JLabel("X:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.EAST;
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 1;
			gbc_lblX.gridy = 2;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			textFieldX = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 2;
			contentPanel.add(textFieldX, gbc_textField);
			textFieldX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Y:");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.EAST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 1;
			gbc_lblY.gridy = 3;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			textFieldY = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 5);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 2;
			gbc_textField_1.gridy = 3;
			contentPanel.add(textFieldY, gbc_textField_1);
			textFieldY.setColumns(10);
		}
		{
			JLabel lblInnerColor = new JLabel("Inner Color:");
			GridBagConstraints gbc_lblInnerColor = new GridBagConstraints();
			gbc_lblInnerColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerColor.gridx = 1;
			gbc_lblInnerColor.gridy = 4;
			contentPanel.add(lblInnerColor, gbc_lblInnerColor);
		}
		{
			JButton buttonInnerColor = new JButton("");
			buttonInnerColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color t= JColorChooser.showDialog(null, "Choose color", innerColor);
					if(t!=null){
						innerColor=t;
						buttonInnerColor.setBackground(innerColor);
					}
				}
			});
			GridBagConstraints gbc_buttonInnerColor = new GridBagConstraints();
			gbc_buttonInnerColor.fill = GridBagConstraints.VERTICAL;
			gbc_buttonInnerColor.insets = new Insets(0, 0, 5, 5);
			gbc_buttonInnerColor.gridx = 2;
			gbc_buttonInnerColor.gridy = 4;
			contentPanel.add(buttonInnerColor, gbc_buttonInnerColor);
		}
		{
			JLabel lblouterColor = new JLabel("outer Color:");
			GridBagConstraints gbc_lblouterColor = new GridBagConstraints();
			gbc_lblouterColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblouterColor.gridx = 1;
			gbc_lblouterColor.gridy = 5;
			contentPanel.add(lblouterColor, gbc_lblouterColor);
		}
		{
			JButton buttonouterColor = new JButton("");
			buttonouterColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color t= JColorChooser.showDialog(null, "Choose color", outerColor);
					if(t!=null){
						outerColor=t;
						buttonouterColor.setBackground(outerColor);
					}
				}
			});
			GridBagConstraints gbc_buttonouterColor = new GridBagConstraints();
			gbc_buttonouterColor.fill = GridBagConstraints.VERTICAL;
			gbc_buttonouterColor.insets = new Insets(0, 0, 0, 5);
			gbc_buttonouterColor.gridx = 2;
			gbc_buttonouterColor.gridy = 5;
			contentPanel.add(buttonouterColor, gbc_buttonouterColor);
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
							int sqX=Integer.parseInt(textFieldX.getText());
							int sqY=Integer.parseInt(textFieldY.getText());
							int sqW=Integer.parseInt(textFieldWidth.getText());
							sq=new Square(new Point(sqX,sqY),sqW,outerColor,innerColor);
							sq.setSelected(true);
							setVisible(false);
							dispose();
						}catch (Exception ex) {
								JOptionPane.showMessageDialog(null, "Please enter a number.");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
