package controller;

import java.awt.Color;

import frame.AppFrame;
import model.DrawingModel;
import shapes.Command;
import shapes.Shape;
import shapes.point.AddPoint;
import shapes.point.Point;

public class LogController {

	private DrawingModel model;
	private AppFrame frame;
	
	public LogController(DrawingModel d, AppFrame f) {
		this.model = d;
		this.frame = f;
	}
	
	
	
	public Command toCommand(String l) {
		return new AddPoint(model, new Point(0, 0, Color.BLACK));
	}
	
	
	
	
}
