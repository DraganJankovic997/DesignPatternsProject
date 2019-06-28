package shapes.point;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Movable;
import shapes.Shape;

public class Point extends Shape implements Movable {

	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Point(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.setColor(c);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public double distance(Point p) {
		int rx = this.getX() - p.getX();
		int ry = this.getY() - p.getY();
		return (double) Math.sqrt(rx*rx + ry*ry);
	}

	@Override
	public String toString() {
		return "(" + this.getX() + "," + this.getY()+ ", " + this.getColor() +")" ;
	}

	@Override
	public boolean equals(Shape s) {
		if(s instanceof Point) {
			Point p = (Point) s;
			if(	this.getX() == p.getX() &&
				this.getY() == p.getY() &&
				this.getColor() == p.getColor()) return true;
			else return false;
		} else return false;
	}

	@Override
	public int compareTo(Shape s) {
		Point p = (Point)s;
		return (int) (this.distance(new Point(0,0)) - p.distance(new Point(0,0)));
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.drawLine(x-1, y-1, x+1, y+1);
		g.drawLine(x-1, y+1, x+1, y-1);
		
		if(this.isSelected()) {
			this.selected(g);
		}
	}

	@Override
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x-1, y-1, 2, 2);
	}

	@Override
	public boolean contains(int x, int y) {
		Point p = new Point(x, y);
		if(this.distance(p) <= 3) return true;
		else return false;
		
	}
	@Override
	public void moveTo(int x, int y) {
		this.setX(x);
		this.setY(y);
		
	}
	@Override
	public void moveFor(int x, int y) {
		this.setX(this.getX() + x);
		this.setY(this.getY() + y);
	}

}
