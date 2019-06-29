package view;

import java.awt.Graphics;
import java.awt.Shape;
import java.util.Iterator;

import javax.swing.JPanel;

import model.DrawingModel;
import shapes.SurfaceShape;

public class DrawingPanelView extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private DrawingModel drawingModel;
	
	public DrawingModel getDrawingModel() {
		return drawingModel;
	}

	public void setDrawingModel(DrawingModel drawingModel) {
		this.drawingModel = drawingModel;
	}

	public DrawingPanelView() {
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(drawingModel != null) {
			for(shapes.Shape s : drawingModel.getShapes()) {
				if(s instanceof SurfaceShape) ((SurfaceShape) s).fill(g);
				s.draw(g);
			}
		}
	}

}
