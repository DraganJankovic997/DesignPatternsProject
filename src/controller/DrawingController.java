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
	private ShapeObserverController obs;
	
	public DrawingController(DrawingModel m, AppFrame f) {
		this.model = m;
		this.frame = f;
		this.obs = new ShapeObserverController(this.model, this.frame);
	}
	
	public void mouseClicked(MouseEvent e) {
		int s = frame.getToolsController().getSelection();
		Color i = frame.getToolsSelectionView().getBtnInnerColor();
		Color o = frame.getToolsSelectionView().getBtnOuterColor();
		if(s == 1) {
			Point p = new Point(e.getX(), e.getY(), o);
			p.addObserver(obs);
			model.addShape(p);
			klik = false;
		} else if (s == 2) {
			if(klik) {
				klik = !klik;
				Line l = new Line(start, new Point(e.getX(), e.getY()), o);
				l.addObserver(obs);
				model.addShape(l);
			} else {
				klik = !klik;
				start = new Point(e.getX(), e.getY());
			}
		} else if(s == 3) {
			if(klik) {
				klik = !klik;
				int w = e.getX() - start.getX();
				Square sq = new Square(start, w, o, i);
				sq.addObserver(obs);
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
				r.addObserver(obs);
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
				c.addObserver(obs);
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
				h.addObserver(obs);
				model.addShape(h);
			} else {
				klik = !klik;
				start = new Point(e.getX(), e.getY());
			}
		} else if(s == 7) {
			boolean selbool = false;
			for(Shape sha: model.getShapes()) {
				if(sha.contains(e.getX(), e.getY())) {
					sha.setSelected(!sha.isSelected());
					selbool = true;
				}
			}
			if(selbool == false) {
				for(Shape huehue: model.getShapes()) huehue.setSelected(false); 
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Please select wanted shape or select tool");
		}
		frame.getDrawingPanelView().repaint();
	}
}
