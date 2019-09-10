package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.JOptionPane;

import frame.AppFrame;
import hexagon.Hexagon;
import model.DrawingModel;
import shapes.Command;
import shapes.Shape;
import shapes.circle.AddCircle;
import shapes.circle.Circle;
import shapes.circle.UpdateCircle;
import shapes.hexagon.AddHexagonAdapter;
import shapes.hexagon.HexagonAdapter;
import shapes.hexagon.UpdateHexagonAdapter;
import shapes.line.AddLine;
import shapes.line.Line;
import shapes.line.UpdateLine;
import shapes.point.AddPoint;
import shapes.point.Point;
import shapes.point.UpdatePoint;
import shapes.rectangle.AddRectangle;
import shapes.rectangle.Rectangle;
import shapes.rectangle.UpdateRectangle;
import shapes.square.AddSquare;
import shapes.square.Square;
import shapes.square.UpdateSquare;

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
		for(Shape sh: model.getShapes()) {
			if(sh.isSelected()) {
				Command cmd = null;
				if(sh instanceof Point) {
					
					Point o = (Point) sh;
					Point n = new Point(o.getX(), o.getY(), o.getColor());
					n.setSelected(false);
					cmd = new UpdatePoint(o, n);
					cmd.execute();
					frame.getMenuController().addUndo(cmd, frame.getMenuController().toLog(cmd, true, o, n));
					frame.getMenuController().LogCommand(cmd, true, (Point)o, n);
				} else if (sh instanceof Line) {
					Line o = (Line) sh;
					Line n = new Line(o.getStartPoint(), o.getEndPoint(), o.getColor());
					n.setSelected(false);
					cmd = new UpdateLine(o, n);
					cmd.execute();
					frame.getMenuController().addUndo(cmd, frame.getMenuController().toLog(cmd, true, o, n));
					frame.getMenuController().LogCommand(cmd, true, o, n);
				} else if (sh instanceof Square) {
					Square o = (Square) sh;
					Square n = new Square(o.getUpperLeftPoint(), o.getWidth(), o.getColor(), o.getInnerColor()); 
					n.setSelected(false);
					cmd = new UpdateSquare(o, n);
					cmd.execute();
					frame.getMenuController().addUndo(cmd, frame.getMenuController().toLog(cmd, true, o, n));
					frame.getMenuController().LogCommand(cmd, true, o, n);
				} else if (sh instanceof Rectangle) {
					Rectangle o = (Rectangle) sh;
					Rectangle n = new Rectangle(o.getUpperLeftPoint(), o.getHeight(), o.getWidth(), o.getColor(), o.getInnerColor());
					n.setSelected(false);
					cmd = new UpdateRectangle(o, n);
					cmd.execute();
					frame.getMenuController().addUndo(cmd, frame.getMenuController().toLog(cmd, true, o, n));
					frame.getMenuController().LogCommand(cmd, true, o, n);
				} else if (sh instanceof Circle) {
					Circle o = (Circle) sh;
					Circle n = new Circle(o.getCenterPoint(), o.getRadius(), o.getColor(), o.getInnerColor());
					n.setSelected(false);
					cmd = new UpdateCircle(o, n);
					cmd.execute();
					frame.getMenuController().addUndo(cmd, frame.getMenuController().toLog(cmd, true, o, n));
					frame.getMenuController().LogCommand(cmd, true, o, n);
				} else if (sh instanceof HexagonAdapter) {
					HexagonAdapter o = (HexagonAdapter) sh;
					HexagonAdapter n = new HexagonAdapter(o.getHexagon(), o.getColor(), o.getInnerColor());
					n.setSelected(false);
					cmd = new UpdateHexagonAdapter(o, n);
					cmd.execute();
					frame.getMenuController().addUndo(cmd, frame.getMenuController().toLog(cmd, true, o, n));
					frame.getMenuController().LogCommand(cmd, true, o, n);
				}
			}
		}
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
				HexagonAdapter h = new HexagonAdapter(he, o, i);
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
			if(selbool == false) {
				unselectAll();
			} else {
				Shape newShape = null;
				Command cmd = null;
				if(selectedShape instanceof Point) {
					Point op = (Point) selectedShape;
					newShape = new Point(op.getX(), op.getY(), op.getColor());
					newShape.setSelected(!op.isSelected());
					newShape.addObserver(obs);
					cmd = new UpdatePoint(op, (Point) newShape);
				} else if (selectedShape instanceof Line) {
					Line ol = (Line) selectedShape;
					newShape = new Line(ol.getStartPoint(), ol.getEndPoint(), ol.getColor());
					newShape.setSelected(!ol.isSelected());
					newShape.addObserver(obs);
					cmd = new UpdateLine(ol, (Line) newShape);
				} else if (selectedShape instanceof Square) {
					Square os = (Square) selectedShape;
					newShape = new Square(os.getUpperLeftPoint(), os.getWidth(), os.getColor(), os.getInnerColor());
					newShape.setSelected(!os.isSelected());
					newShape.addObserver(obs);
					cmd = new UpdateSquare(os, (Square) newShape);
				} else if (selectedShape instanceof Rectangle) {
					Rectangle or = (Rectangle) selectedShape;
					newShape = new Rectangle(or.getUpperLeftPoint(), or.getHeight(), or.getWidth(), or.getColor(), or.getInnerColor());
					newShape.setSelected(!or.isSelected());
					newShape.addObserver(obs);
					cmd = new UpdateRectangle(or, (Rectangle) newShape);
				} else if (selectedShape instanceof Circle) {
					Circle oc = (Circle) selectedShape;
					newShape = new Circle(oc.getCenterPoint(), oc.getRadius(), oc.getColor(), oc.getInnerColor());
					newShape.setSelected(!oc.isSelected());
					newShape.addObserver(obs);
					cmd = new UpdateCircle(oc, (Circle) newShape);
				} else if (selectedShape instanceof HexagonAdapter) {
					HexagonAdapter oha = (HexagonAdapter) selectedShape;
					newShape = new HexagonAdapter(oha.getHexagon(), oha.getColor(), oha.getInnerColor());
					newShape.setSelected(!oha.isSelected());
					newShape.addObserver(obs);
					cmd = new UpdateHexagonAdapter(oha, (HexagonAdapter) newShape);
				}
				frame.getMenuController().addUndo(cmd, frame.getMenuController().toLog(cmd, true, selectedShape, newShape));
				frame.getMenuController().LogCommand(cmd, true, selectedShape, newShape);
				cmd.execute();

				
				
				
			}
			
			
			
			
			
			
			klik = false;
		} else {
			unselectAll();
			JOptionPane.showMessageDialog(frame, "Please select wanted shape or select tool");
		}
		frame.getDrawingPanelView().repaint();
	}
}
