package model;

import java.util.ArrayList;

import shapes.Shape;

public class DrawingModel {

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
}
