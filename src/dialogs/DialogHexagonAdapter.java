package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hexagon.Hexagon;
import shapes.hexagon.HexagonAdapter;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogHexagonAdapter extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfX;
	private JTextField tfY;
	private JTextField tfR;
	private JButton btnOuterColor, btnInnerColor;
	
	private Color outerColor, innerColor;
	private boolean updated = false;
	private HexagonAdapter oldHA, newHA;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogHexagonAdapter dialog = new DialogHexagonAdapter();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogHexagonAdapter() {
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
			JLabel lblX = new JLabel("Centerpoint X :");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 1;
			gbc_lblX.gridy = 1;
			contentPanel.add(lblX, gbc_lblX);
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
			JLabel lblY = new JLabel("Centerpoint Y :");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 1;
			gbc_lblY.gridy = 2;
			contentPanel.add(lblY, gbc_lblY);
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
			JLabel lblR = new JLabel("R :");
			GridBagConstraints gbc_lblR = new GridBagConstraints();
			gbc_lblR.insets = new Insets(0, 0, 5, 5);
			gbc_lblR.gridx = 1;
			gbc_lblR.gridy = 3;
			contentPanel.add(lblR, gbc_lblR);
		}
		{
			tfR = new JTextField();
			GridBagConstraints gbc_tfR = new GridBagConstraints();
			gbc_tfR.anchor = GridBagConstraints.NORTH;
			gbc_tfR.insets = new Insets(0, 0, 5, 0);
			gbc_tfR.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfR.gridx = 3;
			gbc_tfR.gridy = 3;
			contentPanel.add(tfR, gbc_tfR);
			tfR.setColumns(10);
		}
		{
			JLabel label = new JLabel("Outer color :");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 5;
			contentPanel.add(label, gbc_label);
		}
		{
			btnOuterColor = new JButton("Outer color");
			btnOuterColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
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
							int newX = Integer.parseInt(tfX.getText());
							int newY = Integer.parseInt(tfY.getText());
							int newR = Integer.parseInt(tfR.getText());
							Hexagon h = new Hexagon(newX, newY, newR);
							newHA = new HexagonAdapter(h, outerColor, innerColor);
							newHA.setSelected(true);
							updated = true;
							setVisible(false);
							dispose();
						} catch(Exception ex) {
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
	
	public void setHexagonAdapter(HexagonAdapter ha) {
		this.oldHA = ha;
		this.outerColor = ha.getColor();
		this.innerColor = ha.getInnerColor();
		this.btnOuterColor.setBackground(outerColor);
		this.btnInnerColor.setBackground(innerColor);
		this.tfX.setText(String.valueOf(this.oldHA.getHexagon().getX()));
		this.tfY.setText(String.valueOf(this.oldHA.getHexagon().getY()));
		this.tfR.setText(String.valueOf(this.oldHA.getHexagon().getR()));
	}
	
	public HexagonAdapter getHexagonAdapter() {
		return newHA;
	}
	
	public boolean getUpdated() {
		return updated;
	}
	

}
