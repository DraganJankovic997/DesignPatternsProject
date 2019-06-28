package shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Comparable<Shape>  {

	private Color color = Color.BLACK;
	private boolean selected = false;
	
	public Shape() {
		
	}
	public Shape(Color c) {
		this.color = c;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public abstract boolean equals(Shape s);
	public abstract void draw(Graphics g);
	public abstract void selected(Graphics g);
	public abstract boolean contains(int x, int y);
	
	
}
