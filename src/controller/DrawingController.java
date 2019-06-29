package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;

import frame.AppFrame;
import model.DrawingModel;
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
		if(s == 1) {
			model.addShape(new Point(e.getX(), e.getY()));
		} else if (s == 2) {
			if(klik) {
				klik = !klik;
				model.addShape(new Line(start, new Point(e.getX(), e.getY(), Color.BLACK), Color.BLACK));
				start = null;
			} else {
				klik = !klik;
				start = new Point(e.getX(), e.getY(), Color.BLACK);
			}
		} else if(s == 3) {
			System.out.println("selection 3");
			if(klik) {
				klik = !klik;
				int w = e.getX() - start.getX();
				System.out.println("drugi klik : " + w);
				Square sq = new Square(start, w);
				model.addShape(sq);
			} else {
				klik = !klik;
				System.out.println("prvi klik");
				start = new Point(e.getX(), e.getY(), Color.BLACK);
			}
		} else if(s == 4) {
			System.out.println("selection4");
			if(klik) {
				klik = !klik;
				int w = e.getX() - start.getX();
				int h = e.getY() - start.getY();
				Rectangle r = new Rectangle(start, h, w, Color.BLACK);
				model.addShape(r);
			} else {
				klik = !klik;
				start = new Point(e.getX(), e.getY(), Color.BLACK);
			}
		} else if(s == 5) {
			
		} else if(s == 6) {
			
		} else if(s == 7) {
			
		} else {
			
		}
		frame.getDrawingPanelView().repaint();
		System.out.println(model.getShapes());
	}
}
