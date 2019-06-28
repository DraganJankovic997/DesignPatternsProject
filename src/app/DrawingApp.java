package app;

import javax.swing.JFrame;

import controller.DrawingController;
import frame.AppFrame;
import model.DrawingModel;

public class DrawingApp {

	public static void main(String[] args) {
		DrawingModel model = new DrawingModel();
		AppFrame frame = new AppFrame();
		DrawingController drawingController = new DrawingController(model, frame);
		frame.getDrawingPanelView().setDrawingModel(model);
		frame.setDrawingController(drawingController);
		
		
		frame.setSize(1200,800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
