package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import frame.AppFrame;
import model.DrawingModel;
import shapes.Command;
import shapes.Shape;
import shapes.circle.Circle;
import shapes.circle.DeleteCircle;
import shapes.hexagon.DeleteHexagonAdapter;
import shapes.hexagon.HexagonAdapter;
import shapes.line.DeleteLine;
import shapes.line.Line;
import shapes.point.DeletePoint;
import shapes.point.Point;
import shapes.rectangle.DeleteRectangle;
import shapes.rectangle.Rectangle;
import shapes.square.DeleteSquare;
import shapes.square.Square;

public class ModificationController {

	
	private DrawingModel model;
	private AppFrame frame;
	private ShapeObserverController obs;
	
	public ModificationController(DrawingModel d, AppFrame f) {
		this.frame = f;
		this.model = d;
		obs = new ShapeObserverController(model, frame);
	}

	public void deleteClicked(ActionEvent e) {
		List<Shape> ls = new ArrayList<Shape>();
		for(int i = 0; i<model.getShapes().size(); i++) {
			if(model.getOne(i).isSelected() == true) ls.add(model.getOne(i));
		}
		int delDialog = JOptionPane.showConfirmDialog (null, "Are you sure ?","Warning",JOptionPane.YES_NO_OPTION);
		if(delDialog == JOptionPane.YES_OPTION) {
			Command cm = null;
			for(Shape s : ls) {
				if (s instanceof Point) cm = new DeletePoint(model, (Point)s);
				else if(s instanceof Line) cm = new DeleteLine(model, (Line)s);
				else if (s instanceof Square) cm = new DeleteSquare(model, (Square)s);
				else if (s instanceof Rectangle) cm = new DeleteRectangle(model, (Rectangle)s);
				else if (s instanceof Circle) cm = new DeleteCircle(model, (Circle)s);
				else if (s instanceof HexagonAdapter) cm = new DeleteHexagonAdapter(model, (HexagonAdapter)s);
				
				 cm.execute();
			}
			obs.update(new Point(0, 0), new Point(0, 0));
			frame.getDrawingPanelView().repaint();
		}
	}

	public void modifyClicked(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void bringToBackClicked(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void backClicked(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void frontClicked(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void bringToFrontClicked(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}