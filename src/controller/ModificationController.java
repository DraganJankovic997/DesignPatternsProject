package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import dialogs.*;
import frame.AppFrame;
import model.DrawingModel;
import position.BackCommand;
import position.BringToBackCommand;
import position.BringToFrontCommand;
import position.FrontCommand;
import shapes.Command;
import shapes.Shape;
import shapes.circle.Circle;
import shapes.circle.DeleteCircle;
import shapes.circle.UpdateCircle;
import shapes.hexagon.DeleteHexagonAdapter;
import shapes.hexagon.HexagonAdapter;
import shapes.line.DeleteLine;
import shapes.line.Line;
import shapes.line.UpdateLine;
import shapes.point.DeletePoint;
import shapes.point.Point;
import shapes.point.UpdatePoint;
import shapes.rectangle.DeleteRectangle;
import shapes.rectangle.Rectangle;
import shapes.rectangle.UpdateRectangle;
import shapes.square.DeleteSquare;
import shapes.square.Square;
import shapes.square.UpdateSquare;

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
		Shape sel = null;
		Command cm = null;
		
		for (Shape sh : model.getShapes()) {
			if(sh.isSelected() == true) sel = sh;
		}
		
		if(sel instanceof Point) {
			DialogPoint dialog = new DialogPoint();
			dialog.setModal(true);
			dialog.setPoint((Point) sel);
			dialog.setVisible(true);
			if(dialog.getUpdated() == true) {
				cm = new UpdatePoint((Point) sel, dialog.getPoint());
			}
		} else if (sel instanceof Line) {
			DialogLine dialog = new DialogLine();
			dialog.setModal(true);
			dialog.setLine((Line) sel);
			dialog.setVisible(true);
			if(dialog.getUpdated() == true) {
				cm = new UpdateLine((Line) sel, dialog.getLine());
			}
		}
		else if (sel instanceof Square) {
			DialogSquare dialog = new DialogSquare();
			dialog.setModal(true);
			dialog.setSquare((Square) sel);
			dialog.setVisible(true);
			if(dialog.getUpdated() == true) {
				cm = new UpdateSquare((Square) sel, dialog.getSquare());
			}
		} else if (sel instanceof Rectangle) {
			DialogRectangle dialog = new DialogRectangle();
			dialog.setModal(true);
			dialog.setRectangle((Rectangle) sel);
			dialog.setVisible(true);
			if(dialog.getUpdated() == true) {
				cm = new UpdateRectangle((Rectangle) sel, dialog.getRectangle());
			}
		} else if (sel instanceof Circle) {
			DialogCircle dialog = new DialogCircle();
			dialog.setModal(true);
			dialog.setCircle((Circle) sel);
			dialog.setVisible(true);
			if(dialog.getUpdated() == true) {
				cm = new UpdateCircle((Circle) sel, dialog.getCircle());
			}
		}
		cm.execute();
		frame.getDrawingPanelView().repaint();
	}

	public void bringToBackClicked(ActionEvent e) {
		Shape sh = null;
		for(int i = 0; i<model.getShapes().size()-1; i++) if(model.getOne(i).isSelected() == true) sh = model.getOne(i);
		
		BringToBackCommand cm = new BringToBackCommand(model, sh);
		try {
			int op = model.getShapes().indexOf(sh);
			cm.execute();
			int np = model.getShapes().indexOf(sh);
			System.out.println(op + " ----> " + np);
		} catch (Exception ex) {
			if(model.getShapes().indexOf(sh) == 0)JOptionPane.showMessageDialog(frame, "Shape is already on bottom");
			else JOptionPane.showMessageDialog(frame, "Bringing to bottom error");
		}
		frame.getDrawingPanelView().repaint();
	}

	public void backClicked(ActionEvent e) {
		Shape sh = null;
		for(int i = 0; i<model.getShapes().size()-1; i++) if(model.getOne(i).isSelected() == true) sh = model.getOne(i);
		
		BackCommand cm = new BackCommand(model, sh);
		try {
			int op = model.getShapes().indexOf(sh);
			cm.execute();
			int np = model.getShapes().indexOf(sh);
			System.out.println(op + " ----> " + np);
		} catch (Exception ex) {
			if(model.getShapes().indexOf(sh) == 0)JOptionPane.showMessageDialog(frame, "Shape is already on bottom");
			else JOptionPane.showMessageDialog(frame, "To bottom error");
		}
		frame.getDrawingPanelView().repaint();
	}

	public void frontClicked(ActionEvent e) {
		Shape sh = null;
		for(int i = 0; i<model.getShapes().size()-1; i++) if(model.getOne(i).isSelected() == true) sh = model.getOne(i);
		
		FrontCommand cm = new FrontCommand(model, sh);
		try {
			int op = model.getShapes().indexOf(sh);
			cm.execute();
			int np = model.getShapes().indexOf(sh);
			System.out.println(op + " ----> " + np);
		} catch (Exception ex) {
			if(model.getShapes().indexOf(sh) == model.getShapes().size()-1)
				JOptionPane.showMessageDialog(frame, "Shape is already on top");
			else JOptionPane.showMessageDialog(frame, "Bring to top error");
		}
		frame.getDrawingPanelView().repaint();
	}

	public void bringToFrontClicked(ActionEvent e) {
		Shape sh = null;
		for(int i = 0; i<model.getShapes().size()-1; i++) if(model.getOne(i).isSelected() == true) sh = model.getOne(i);
		
		BringToFrontCommand cm = new BringToFrontCommand(model, sh);
		try {
			int op = model.getShapes().indexOf(sh);
			cm.execute();
			int np = model.getShapes().indexOf(sh);
			System.out.println(op + " ----> " + np);
		} catch (Exception ex) {
			if(model.getShapes().indexOf(sh) == model.getShapes().size()-1)
				JOptionPane.showMessageDialog(frame, "Shape is already on top");
			else JOptionPane.showMessageDialog(frame, "To top error");
		}
		frame.getDrawingPanelView().repaint();
	}
	
	
	
	
	
}
