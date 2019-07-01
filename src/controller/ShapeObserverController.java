package controller;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import frame.AppFrame;
import model.DrawingModel;
import shapes.Shape;

public class ShapeObserverController implements Observer {

	private DrawingModel model;
	private AppFrame frame;
	
	public ShapeObserverController(DrawingModel d, AppFrame f) {
		this.model = d;
		this.frame = f;
	}
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		int selCount = 0;
		for(Shape s: model.getShapes() ) if(s.isSelected() == true) selCount++;
		if(selCount == 0) {
			frame.getModificationView().getBtnDelete().setEnabled(false);
			frame.getModificationView().getBtnModify().setEnabled(false);
			frame.getModificationView().getBtnBringToBack().setEnabled(false);
			frame.getModificationView().getBtnBack().setEnabled(false);
			frame.getModificationView().getBtnFront().setEnabled(false);
			frame.getModificationView().getBtnBringToFront().setEnabled(false);
		} else if (selCount == 1) {
			frame.getModificationView().getBtnDelete().setEnabled(true);
			frame.getModificationView().getBtnModify().setEnabled(true);
			frame.getModificationView().getBtnBringToBack().setEnabled(true);
			frame.getModificationView().getBtnBack().setEnabled(true);
			frame.getModificationView().getBtnFront().setEnabled(true);
			frame.getModificationView().getBtnBringToFront().setEnabled(true);
		} else {
			frame.getModificationView().getBtnDelete().setEnabled(true);
			frame.getModificationView().getBtnModify().setEnabled(false);
			frame.getModificationView().getBtnBringToBack().setEnabled(false);
			frame.getModificationView().getBtnBack().setEnabled(false);
			frame.getModificationView().getBtnFront().setEnabled(false);
			frame.getModificationView().getBtnBringToFront().setEnabled(false);
		}
		
	}

}
