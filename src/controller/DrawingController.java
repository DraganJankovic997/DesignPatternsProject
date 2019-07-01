package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.JOptionPane;

import frame.AppFrame;
import hexagon.Hexagon;
import model.DrawingModel;
import shapes.Shape;
import shapes.circle.AddCircle;
import shapes.circle.Circle;
import shapes.hexagon.AddHexagonAdapter;
import shapes.hexagon.HexagonAdapter;
import shapes.line.AddLine;
import shapes.line.Line;
import shapes.point.AddPoint;
import shapes.point.Point;
import shapes.rectangle.AddRectangle;
import shapes.rectangle.Rectangle;
import shapes.square.AddSquare;
import shapes.square.Square;

public class DrawingController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5838960646165421837L;
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
	
	public void unselectAll() {
		for(Shape huehue: model.getShapes()) huehue.setSelected(false);
	}
	
	public void mouseClicked(MouseEvent e) {
		int s = frame.getToolsController().getSelection();
		Color i = frame.getToolsSelectionView().getBtnInnerColor();
		Color o = frame.getToolsSelectionView().getBtnOuterColor();
		if(s == 1) {
			unselectAll();
			Point p = new Point(e.getX(), e.getY(), o);
			p.addObserver(obs);
			AddPoint a = new AddPoint(model, p);
			a.execute();
			frame.getMenuController().addUndo(a, frame.getMenuController().toLog(a, true, p, null)); 
			frame.getMenuController().LogCommand(a, true, p, null);
			klik = false;
		} else if (s == 2) {
			unselectAll();
			if(klik) {
				klik = !klik;
				Line l = new Line(start, new Point(e.getX(), e.getY()), o);
				l.addObserver(obs);
				AddLine a = new AddLine(model, l);
				a.execute();
				frame.getMenuController().addUndo(a, frame.getMenuController().toLog(a, true, l, null));
				frame.getMenuController().LogCommand(a, true, l, null);
			} else {
				klik = !klik;
				start = new Point(e.getX(), e.getY());
			}
		} else if(s == 3) {
			unselectAll();
			if(klik) {
				klik = !klik;
				int w = Math.abs(e.getX() - start.getX());
				Square sq = new Square(start, w, o, i);
				sq.addObserver(obs);
				AddSquare a = new AddSquare(model, sq);
				frame.getMenuController().addUndo(a, "kek");
				a.execute();
				frame.getMenuController().addUndo(a, frame.getMenuController().toLog(a, true, sq, null));
				frame.getMenuController().LogCommand(a, true, sq, null);
			} else {
				klik = !klik;
				start = new Point(e.getX(), e.getY());
			}
		} else if(s == 4) {
			unselectAll();
			if(klik) {
				klik = !klik;
				int w = Math.abs(e.getX() - start.getX());
				int h = Math.abs(e.getY() - start.getY());
				Rectangle r = new Rectangle(start, h, w, o, i);
				r.addObserver(obs);
				AddRectangle a = new AddRectangle(model, r);
				a.execute();
				frame.getMenuController().addUndo(a, frame.getMenuController().toLog(a, true, r, null));
				frame.getMenuController().LogCommand(a, true, r, null);
			} else {
				klik = !klik;
				start = new Point(e.getX(), e.getY());
			}
		} else if(s == 5) {
			unselectAll();
			if(klik) {
				klik = !klik;
				int r = (int) start.distance(new Point(e.getX(), e.getY()));
				Circle c = new Circle(start, r, o, i);
				c.addObserver(obs);
				AddCircle a = new AddCircle(model, c);
				a.execute();
				frame.getMenuController().addUndo(a, frame.getMenuController().toLog(a, true, c, null));
				frame.getMenuController().LogCommand(a, true, c, null);
			} else {
				klik = !klik;
				start = new Point(e.getX(), e.getY());
			}
		} else if(s == 6) {
			unselectAll();
			if(klik) {
				klik = !klik;
				int r = (int) start.distance(new Point(e.getX(), e.getY()));
				Hexagon he = new Hexagon(start.getX(), start.getY(), r);
				he.setBorderColor(o);
				he.setAreaColor(i);
				HexagonAdapter h = new HexagonAdapter(he);
				h.addObserver(obs);
				AddHexagonAdapter a = new AddHexagonAdapter(model, h);
				a.execute();
				frame.getMenuController().addUndo(a, frame.getMenuController().toLog(a, true, h, null));
				frame.getMenuController().LogCommand(a, true, h, null);
			} else {
				klik = !klik;
				start = new Point(e.getX(), e.getY());
			}
		} else if(s == 7) {
			boolean selbool = false;
			Shape selectedShape = null;
			for(Shape sha: model.getShapes()) {
				if(sha.contains(e.getX(), e.getY())) {
					selectedShape = sha;
					selbool = true;
				}
			}
			selectedShape.setSelected(!selectedShape.isSelected());
			if(selbool == false) {
				unselectAll();
			}
			klik = false;
		} else {
			unselectAll();
			JOptionPane.showMessageDialog(frame, "Please select wanted shape or select tool");
		}
		frame.getDrawingPanelView().repaint();
	}
}
