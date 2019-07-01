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

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogPoint extends JDialog {

	private static final long serialVersionUID = 5652194321656403879L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfX;
	private JTextField tfY;
	private JButton btnOuter;
	private Point oldPoint, newPoint;
	private Color outerColor;
	private boolean updated = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogPoint dialog = new DialogPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogPoint() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("X :");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.anchor = GridBagConstraints.EAST;
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
			gbc_tfX.gridx = 2;
			gbc_tfX.gridy = 1;
			contentPanel.add(tfX, gbc_tfX);
			tfX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Y : ");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.EAST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 1;
			gbc_lblY.gridy = 2;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			tfY = new JTextField();
			tfY.setText("");
			GridBagConstraints gbc_tfY = new GridBagConstraints();
			gbc_tfY.insets = new Insets(0, 0, 5, 0);
			gbc_tfY.fill = GridBagConstraints.HORIZONTAL;
			gbc_tfY.gridx = 2;
			gbc_tfY.gridy = 2;
			contentPanel.add(tfY, gbc_tfY);
			tfY.setColumns(10);
		}
		{
			JLabel lblOuterColor = new JLabel("Outer Color :");
			GridBagConstraints gbc_lblOuterColor = new GridBagConstraints();
			gbc_lblOuterColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblOuterColor.gridx = 1;
			gbc_lblOuterColor.gridy = 3;
			contentPanel.add(lblOuterColor, gbc_lblOuterColor);
		}
		{
			btnOuter = new JButton("Outer color");
			btnOuter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color t= JColorChooser.showDialog(null, "Choose outer color", outerColor);
					if(t!=null){
						outerColor=t;
						btnOuter.setBackground(outerColor);
					}
				}
			});
			GridBagConstraints gbc_btnOuter = new GridBagConstraints();
			gbc_btnOuter.gridx = 2;
			gbc_btnOuter.gridy = 3;
			contentPanel.add(btnOuter, gbc_btnOuter);
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
							newPoint = new Point(Integer.parseInt(tfX.getText()), Integer.parseInt(tfY.getText()), outerColor);
							newPoint.setSelected(true);
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
	
	public Point getPoint() {
		return newPoint;
	}
	public void setPoint(Point po) {
		this.oldPoint = po;
		this.outerColor = oldPoint.getColor();
		this.btnOuter.setBackground(outerColor);
		this.tfX.setText(String.valueOf(oldPoint.getX()));
		this.tfY.setText(String.valueOf(oldPoint.getY()));
	}
	
	public boolean getUpdated() {
		return updated;
	}

}
