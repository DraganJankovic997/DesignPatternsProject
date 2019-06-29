package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import frame.AppFrame;
import hexagon.Hexagon;
import model.DrawingModel;
import shapes.Shape;
import shapes.circle.Circle;
import shapes.hexagon.HexagonAdapter;
import shapes.line.Line;
import shapes.point.Point;
import shapes.rectangle.Rectangle;
import shapes.square.Square;

public class DrawingController {

	private DrawingModel model;
	private AppFrame frame;
	private boolean klik = false ;
	private Point start;
	
	public DrawingController(DrawingModel m, AppFrame f) {
		this.model = m;
		this.frame = f;
	}
	
	public void mouseClicked(MouseEvent e) {
		int s = frame.getToolsController().getSelection();
		Color i = frame.getToolsSelectionView().getBtnInnerColor();
		Color o = frame.getToolsSelectionView().getBtnOuterColor();
		if(s == 1) {
			model.addShape(new Point(e.getX(), e.getY(), o));
			klik = false;
		} else if (s == 2) {
			if(klik) {
				klik = !klik;
				model.addShape(new Line(start, new Point(e.getX(), e.getY()), o));
				start = null;
			} else {
				klik = !klik;
				start = new Point(e.getX(), e.getY());
			}
		} else if(s == 3) {
			if(klik) {
				klik = !klik;
				int w = e.getX() - start.getX();
				Square sq = new Square(start, w, o, i);
				model.addShape(sq);
			} else {
				klik = !klik;
				start = new Point(e.getX(), e.getY());
			}
		} else if(s == 4) {
			if(klik) {
				klik = !klik;
				int w = e.getX() - start.getX();
				int h = e.getY() - start.getY();
				Rectangle r = new Rectangle(start, h, w, o, i);
				model.addShape(r);
			} else {
				klik = !klik;
				start = new Point(e.getX(), e.getY());
			}
		} else if(s == 5) {
			if(klik) {
				klik = !klik;
				int r = (int) start.distance(new Point(e.getX(), e.getY()));
				Circle c = new Circle(start, r, o, i);
				model.addShape(c);
			} else {
				klik = !klik;
				start = new Point(e.getX(), e.getY());
			}
		} else if(s == 6) {
			if(klik) {
				klik = !klik;
				int r = (int) start.distance(new Point(e.getX(), e.getY()));
				Hexagon he = new Hexagon(start.getX(), start.getY(), r);
				he.setBorderColor(o);
				he.setAreaColor(i);
				HexagonAdapter h = new HexagonAdapter(he);
				model.addShape(h);
			} else {
				klik = !klik;
				start = new Point(e.getX(), e.getY());
			}
		} else if(s == 7) {
			for(Shape sha: model.getShapes()) if(sha.contains(e.getX(), e.getY())) sha.setSelected(!sha.isSelected());
		} else {
			JOptionPane.showMessageDialog(frame, "Please select wanted shape or select tool");
		}
		frame.getDrawingPanelView().repaint();
	}
}
