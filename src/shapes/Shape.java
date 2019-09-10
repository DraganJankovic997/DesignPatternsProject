package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Observable;

public abstract class Shape extends Observable implements Comparable<Shape>, Serializable, Prototype  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1054899297990149860L;
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
		setChanged();
		notifyObservers();
	}
	
	public abstract boolean equals(Shape s);
	public abstract void draw(Graphics g);
	public abstract void selected(Graphics g);
	public abstract boolean contains(int x, int y);
	public abstract Shape clone();
	
}
