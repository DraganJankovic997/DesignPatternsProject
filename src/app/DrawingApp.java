package app;

import javax.swing.JFrame;

import controller.DrawingController;
import controller.ModificationController;
import controller.ToolsController;
import frame.AppFrame;
import model.DrawingModel;

public class DrawingApp {

	public static void main(String[] args) {
		DrawingModel model = new DrawingModel();
		AppFrame frame = new AppFrame();
		DrawingController drawingController = new DrawingController(model, frame);
		ToolsController toolsController = new ToolsController(model, frame);
		ModificationController modificationController = new ModificationController(model, frame);
		frame.getDrawingPanelView().setDrawingModel(model);
		frame.setDrawingController(drawingController);
		frame.setToolsController(toolsController);
		frame.setModificationController(modificationController);
		
		
		frame.setSize(600,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
