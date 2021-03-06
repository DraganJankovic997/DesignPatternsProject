package shapes.circle;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Movable;
import shapes.Prototype;
import shapes.Shape;
import shapes.SurfaceShape;
import shapes.line.Line;
import shapes.point.Point;

public class Circle extends SurfaceShape implements Movable, Prototype {

	private static final long serialVersionUID = 1051419297990144860L;
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
	public String toString() {
		return String.format("Circle(X=%d,Y=%d,r=%d,outercolor=[%d-%d-%d],innercolor=[%d-%d-%d],selected=%b)", this.getCenterPoint().getX(),
				this.getCenterPoint().getY(), this.radius, getColor().getRed(), getColor().getGreen(), getColor().getBlue(),
				getInnerColor().getRed(), getInnerColor().getGreen(), getInnerColor().getBlue(),isSelected());
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
		Point p1 = new Point(centerPoint.getX() - radius, centerPoint.getY());
		Point p2 = new Point(centerPoint.getX() + radius, centerPoint.getY());
		Point p3 = new Point(centerPoint.getX(), centerPoint.getY() - radius);
		Point p4 = new Point(centerPoint.getX(), centerPoint.getY() + radius);
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
			if(centerPoint.equals(c.getCenterPoint()) && radius == c.getRadius() && this.getColor().getRGB() == c.getColor().getRGB()
					&& this.getInnerColor().getRGB() == c.getInnerColor().getRGB()) {
				return true;
			}
			else return false;
		} else return false;
	}

	@Override
	public Shape clone() {
		Circle c = new Circle(this.getCenterPoint(), this.getRadius(), this.getColor(), this.getInnerColor());
		c.setSelected(this.isSelected());
		return c;
	}

}
