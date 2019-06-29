package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import frame.AppFrame;
import model.DrawingModel;
import shapes.Shape;

public class ModificationController {

	
	private DrawingModel model;
	private AppFrame frame;
	private ShapeObserverController obs;
	
	public ModificationController(DrawingModel d, AppFrame f) {
		this.frame = f;
		this.model = d;
		obs = new ShapeObserverController(model, frame);
	}

	public void deleteClicked(ActionEvent e) {
		List<Shape> ls = new ArrayList<Shape>();
		for(int i = 0; i<model.getShapes().size(); i++) {
			if(model.getOne(i).isSelected() == true) ls.add(model.getOne(i));
		}
		
		for(Shape s : ls) model.deleteShape(s);
		obs.update(model.getOne(1), ls);
		frame.getDrawingPanelView().repaint();
	}

	public void modifyClicked(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void bringToBackClicked(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void backClicked(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void frontClicked(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void bringToFrontClicked(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
