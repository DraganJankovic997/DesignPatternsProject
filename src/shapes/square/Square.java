package shapes.square;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Movable;
import shapes.Shape;
import shapes.SurfaceShape;
import shapes.line.Line;
import shapes.point.Point;
import shapes.rectangle.Rectangle;

public class Square extends SurfaceShape implements Movable {

	private Point upperLeftPoint;
	private int width;
	
	public Square(Point p, int w) {
		this.upperLeftPoint = p;
		this.width = w;
	}
	
	public Square(Point p, int w, Color c) {
		this.upperLeftPoint = p;
		this.width = w;
		this.setColor(c);
	}
	
	public Square(Point p, int w, Color c, Color ic) {
		this.upperLeftPoint = p;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void moveTo(int x, int y) {
		this.upperLeftPoint.moveTo(x, y);
	}

	@Override
	public void moveFor(int x, int y) {
		this.upperLeftPoint.moveFor(x, y);

	}

	@Override
	public int compareTo(Shape s) {
		if(s instanceof Square) {
			Square k = (Square) s;
			return (width * width) - (k.getWidth() * k.getWidth());
		} else return 0;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(this.getInnerColor());
		g.fillRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, width);
		if(this.isSelected()) this.selected(g);
	}

	@Override
	public boolean equals(Shape s) {
		if(s instanceof Square) {
			Square k = (Square) s;
			if(upperLeftPoint.equals(k.getUpperLeftPoint()) && width == k.getWidth() && this.getColor() == k.getColor()
					&& this.getInnerColor() == k.getInnerColor()) {
				return true;
			}
			else return false;
		} else return false;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, width);
		if(this.isSelected()) this.selected(g);
	}

	@Override
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		Point dlp = new Point (upperLeftPoint.getX(), upperLeftPoint.getY() + width);
		Point drp = new Point (upperLeftPoint.getX() + width, upperLeftPoint.getY() + width);
		Point urp = new Point (upperLeftPoint.getX() + width, upperLeftPoint.getY());
		
		new Line (upperLeftPoint, dlp).selected(g);
		new Line (dlp, drp).selected(g);
		new Line (drp, urp).selected(g);
		new Line (urp, upperLeftPoint).selected(g);
		
	}

	@Override
	public boolean contains(int x, int y) {
		if (upperLeftPoint.getX() <= x  && x <= (upperLeftPoint.getX() + width)
				&& upperLeftPoint.getY() <= y && y <= (upperLeftPoint.getY() + width)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String s = upperLeftPoint.toString() + ", width = " + width + " |color" + this.getColor() + "|inner " + this.getInnerColor();
		return s;
	}

}
