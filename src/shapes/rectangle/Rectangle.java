package shapes.rectangle;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Movable;
import shapes.Shape;
import shapes.SurfaceShape;
import shapes.circle.Circle;
import shapes.line.Line;
import shapes.point.Point;
import shapes.Prototype;

public class Rectangle extends SurfaceShape implements Movable, Prototype {

	private Point upperLeftPoint;
	private int height;
	private int width;
	
	public Rectangle(Point p, int h, int w) {
		this.upperLeftPoint = p;
		this.height = h;
		this.width = w;
	}
	
	public Rectangle(Point p, int h, int w, Color c) {
		this.upperLeftPoint = p;
		this.height = h;
		this.width = w;
		this.setColor(c);
	}

	public Rectangle(Point p, int h, int w, Color c, Color ic) {
		this.upperLeftPoint = p;
		this.height = h;
		this.width = w;
		this.setColor(c);
		this.setInnerColor(ic);
	}
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void moveTo(int x, int y) {
		upperLeftPoint.moveTo(x, y);
	}

	@Override
	public void moveFor(int x, int y) {
		upperLeftPoint.moveFor(x, y);
	}

	public int surface() {
		return this.getHeight() * this.getWidth();
	}
	
	@Override
	public int compareTo(Shape s) {
		if(s instanceof Rectangle) {
			Rectangle r = (Rectangle) s;
			return this.surface() - r.surface();
		} else return 0;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(this.getInnerColor());
		g.fillRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		if(this.isSelected()) this.selected(g);
	}

	@Override
	public boolean equals(Shape s) {
		if(s instanceof Rectangle) {
			Rectangle r = (Rectangle) s;
			if(upperLeftPoint.equals(r.getUpperLeftPoint()) && height == r.getHeight() && width == r.getWidth() && this.getColor() == r.getColor()
					&& this.getInnerColor() == r.getInnerColor()) {
				return true;
			}
			else return false;
		} else return false;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		if(this.isSelected()) this.selected(g);
	}

	@Override
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		Point dlp = new Point (upperLeftPoint.getX(), upperLeftPoint.getY() + height);
		Point drp = new Point (upperLeftPoint.getX() + width, upperLeftPoint.getY() + height);
		Point urp = new Point (upperLeftPoint.getX() + width, upperLeftPoint.getY());
		
		new Line (upperLeftPoint, dlp).selected(g);
		new Line (dlp, drp).selected(g);
		new Line (drp, urp).selected(g);
		new Line (urp, upperLeftPoint).selected(g);
	}

	@Override
	public boolean contains(int x, int y) {
		if (upperLeftPoint.getX() <= x  && x <= (upperLeftPoint.getX() + width)
				&& upperLeftPoint.getY() <= y && y <= (upperLeftPoint.getY() + height)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Shape clone() {
		Rectangle r = new Rectangle(this.getUpperLeftPoint(), this.getHeight(), this.getWidth(), this.getColor(), this.getInnerColor());
		r.setSelected(this.isSelected());
		return r;
	}

}
