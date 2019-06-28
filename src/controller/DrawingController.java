package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;

import frame.AppFrame;
import model.DrawingModel;
import shapes.point.Point;

public class DrawingController {

	private DrawingModel drawingModel;
	private AppFrame drawingFrame;
	
	public DrawingController(DrawingModel m, AppFrame f) {
		this.drawingModel = m;
		this.drawingFrame = f;
	}
	
	
	public void mouseClicked(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY(), Color.BLUE);
		drawingModel.addShape(p);
		System.out.println(p);
		drawingFrame.getDrawingPanelView().repaint();
	}
}
