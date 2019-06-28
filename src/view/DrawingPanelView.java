package view;

import java.awt.Graphics;
import java.awt.Shape;
import java.util.Iterator;

import javax.swing.JPanel;

import model.DrawingModel;

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
			Iterator<shapes.Shape> i = drawingModel.getShapes().iterator();
			while(i.hasNext()) {
				i.next().draw(g);
			}
		}
	}

}
