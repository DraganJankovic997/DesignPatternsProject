package shapes.line;


import java.awt.Color;
import java.awt.Graphics;

import shapes.Movable;
import shapes.Shape;
import shapes.point.Point;

public class Line extends Shape implements Movable {

	private Point startPoint;
	private Point endPoint;
	
	public Line(Point sp, Point ep, Color c) {
		this.startPoint = sp;
		this.endPoint = ep;
		this.setColor(c);
	}
	
	public Line(Point sp, Point ep) {
		this.startPoint = sp;
		this.endPoint = ep;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	public double length() {
		return startPoint.distance(endPoint);
	}
	
	public String toString() {
		return startPoint.toString() + "->" + endPoint.toString();
	}

	@Override
	public void moveTo(int x, int y) {
		int rx = x - startPoint.getX();
		int ry = y - startPoint.getY();
		startPoint.moveTo(x, y);
		endPoint.moveFor(rx, ry);
	}

	@Override
	public void moveFor(int x, int y) {
		this.startPoint.moveFor(x, y);
		this.endPoint.moveFor(x, y);
	}

	@Override
	public int compareTo(Shape s) {
		if(s instanceof Line) {
			Line l = (Line) s;
			return (int) (this.length() - l.length());
		} else return 0;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if(this.isSelected()) this.selected(g);
	}
	
	public Point middlePoint() {
		int sx = (startPoint.getX() + endPoint.getX())/2;
		int sy = (startPoint.getY() + endPoint.getY())/2;
		return new Point(sx, sy);
	}
	
	@Override
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		startPoint.selected(g);
		endPoint.selected(g);
		this.middlePoint().selected(g);
	}

	@Override
	public boolean contains(int x, int y) {
		Point p = new Point(x, y);
		double ds = startPoint.distance(p);
		double de = endPoint.distance(p);
		if (ds + de <= this.length() + 0.05) return true;
		else return false;
	}

	@Override
	public boolean equals(Shape s) {
		if(s instanceof Line) {
			Line l = (Line) s;
			if(startPoint.equals(l.getStartPoint()) && endPoint.equals(l.getEndPoint()) && this.getColor() == l.getColor()) {
				return true;
			}
			else return false;
		} else return false;
	}

}
