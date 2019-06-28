package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DrawingController;
import controller.MenuController;
import controller.ToolsController;
import view.DrawingPanelView;
import view.ToolsSelectionView;

public class AppFrame extends JFrame {

	private JPanel contentPane;
	private DrawingPanelView drawingPanelView = new DrawingPanelView();
	private ToolsSelectionView toolsSelectionView = new ToolsSelectionView();
	private DrawingController drawingController;
	
	public DrawingPanelView getDrawingPanelView () {
		return drawingPanelView;
	}
	
	public void setDrawingController(DrawingController c) {
		this.drawingController = c;
	}
	

	/**
	 * Create the frame.
	 */
	public AppFrame() {
		setTitle("Dragan Jankovic IT47-2016 DP");
		drawingPanelView.setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		drawingPanelView.addMouseListener( new MouseAdapter () {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				drawingController.mouseClicked(arg0);
			}
		});
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(drawingPanelView);
		getContentPane().add(toolsSelectionView, BorderLayout.WEST);
	}

}
