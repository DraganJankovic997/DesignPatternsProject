package model;

import java.io.Serializable;
import java.util.ArrayList;

import shapes.Shape;

public class DrawingModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9062290383518987403L;
	private ArrayList<Shape> shapesList = new ArrayList<Shape>();
	
	public ArrayList<Shape> getShapes(){
		return shapesList;
	}
	
	public Shape getOne(int i) {
		return shapesList.get(i);
	}
	
	public void addShape(Shape s) {
		shapesList.add(s);
	}
	
	public void deleteShape(Shape s) {
		shapesList.remove(s);
	}
	public void insertInto(Shape s, int pos) {
		shapesList.add(pos, s);
	}
}
