package shapes.circle;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Movable;
import shapes.Shape;
import shapes.SurfaceShape;
import shapes.line.Line;
import shapes.point.Point;

public class Circle extends SurfaceShape implements Movable {

	private Point centerPoint;
	private int radius;
	
	public Circle(Point p, int r) {
		this.centerPoint = p;
		this.radius = r;
	}
	
	public Circle(Point p, int r, Color c) {
		this.centerPoint = p;
		this.radius = r;
		this.setColor(c);
	}
	
	public Circle(Point p, int r, Color c, Color ic) {
		this.centerPoint = p;
		this.radius = r;
		this.setColor(c);
		this.setInnerColor(ic);
	}
	
	public Point getCenterPoint() {
		return centerPoint;
	}

	public void setCenterPoint(Point centerPoint) {
		this.centerPoint = centerPoint;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void moveTo(int x, int y) {
		this.centerPoint.moveTo(x, y);
	}

	@Override
	public void moveFor(int x, int y) {
		this.centerPoint.moveFor(x, y);

	}

	@Override
	public int compareTo(Shape s) {
		if(s instanceof Circle) {
			Circle c = (Circle) s;
			return this.getRadius() - c.getRadius();
		} else return 0;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(this.getInnerColor());
		g.fillOval(centerPoint.getX() - radius, 
				centerPoint.getY() - radius , 
				2*radius, 2*radius);
		if(this.isSelected()) this.selected(g);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.drawOval(centerPoint.getX() - radius, 
				centerPoint.getY() - radius , 
				2*radius, 2*radius);
		if(this.isSelected()) this.selected(g);
	}

	@Override
	public void selected(Graphics g) {
		Point p1 = new Point(centerPoint.getX() - radius, centerPoint.getY() - radius);
		Point p2 = new Point(centerPoint.getX() - radius, centerPoint.getY() + radius);
		Point p3 = new Point(centerPoint.getX() + radius, centerPoint.getY() - radius);
		Point p4 = new Point(centerPoint.getX() + radius, centerPoint.getY() + radius);
		p1.selected(g);
		p2.selected(g);
		p3.selected(g);
		p4.selected(g);
		centerPoint.selected(g);
	}

	@Override
	public boolean contains(int x, int y) {
		Point p = new Point(x, y);
		if(centerPoint.distance(p) <= radius) return true;
		else return false;
	}

	@Override
	public boolean equals(Shape s) {
		if(s instanceof Circle) {
			Circle c = (Circle) s;
			if(centerPoint.equals(c.getCenterPoint()) && radius == c.getRadius() && this.getColor() == c.getColor()
					&& this.getInnerColor() == c.getInnerColor()) {
				return true;
			}
			else return false;
		} else return false;
	}

}
