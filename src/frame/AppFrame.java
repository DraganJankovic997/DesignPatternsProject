package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DrawingController;
import controller.MenuController;
import controller.ModificationController;
import controller.ToolsController;
import view.DrawingPanelView;
import view.LogView;
import view.MenuView;
import view.ModificationView;
import view.ToolsSelectionView;

public class AppFrame extends JFrame {

	private JPanel contentPane;
	private DrawingPanelView drawingPanelView = new DrawingPanelView();
	private ToolsSelectionView toolsSelectionView = new ToolsSelectionView();
	private MenuView menuView = new MenuView();
	private ModificationView modificationView = new ModificationView();
	private LogView logView = new LogView();
	private DrawingController drawingController;
	private ToolsController toolsController;
	private ModificationController modificationController;
	
	public DrawingPanelView getDrawingPanelView () {
		return drawingPanelView;
	}
	
	public void setDrawingController(DrawingController c) {
		this.drawingController = c;
	}
	
	public void setToolsController(ToolsController t) {
		this.toolsController = t;
	}
	
	public void setModificationController(ModificationController m) {
		this.modificationController = m;
	}
	
	public ToolsController getToolsController() {
		return toolsController;
	}
	
	public ToolsSelectionView getToolsSelectionView() {
		return toolsSelectionView;
	}
	
	public ModificationController getModificationController() {
		return modificationController;
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
				try {
					drawingController.mouseClicked(arg0);
				} catch(Exception ex) {
					drawingController.unselectAll();
					getDrawingPanelView().repaint();
				}
			}
		});
		
		toolsSelectionView.getBtnPoint().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.pointSelected(e);
			}
		});
		toolsSelectionView.getBtnLine().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.lineSelected(e);
			}
		});
		toolsSelectionView.getBtnSquare().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.squareSelected(e);
			}
		});
		toolsSelectionView.getBtnRectangle().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.rectangleSelected(e);
			}
		});
		toolsSelectionView.getBtnCircle().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.circleSelected(e);
			}
		});
		toolsSelectionView.getBtnHexagon().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.hexagonSelected(e);
			}
		});
		toolsSelectionView.getBtnSelect().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toolsController.selectSelected(e);
			}
		});
		modificationView.getBtnModify().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modificationController.modifyClicked(e);
			}
		});
		modificationView.getBtnDelete().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modificationController.deleteClicked(e);
			}
		});
		modificationView.getBtnBringToBack().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modificationController.bringToBackClicked(e);
			}
		});
		modificationView.getBtnBack().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modificationController.backClicked(e);
			}
		});
		modificationView.getBtnFront().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modificationController.frontClicked(e);
			}
		});
		modificationView.getBtnBringToFront().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modificationController.bringToFrontClicked(e);
			}
		});
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(drawingPanelView);
		getContentPane().add(toolsSelectionView, BorderLayout.WEST);
		getContentPane().add(menuView, BorderLayout.NORTH);
		getContentPane().add(modificationView, BorderLayout.EAST);
		logView.setPreferredSize(new Dimension(100, 100));
		getContentPane().add(logView, BorderLayout.SOUTH);
	}

	public ModificationView getModificationView() {
		return modificationView;
		
	}

}
