package shapes.point;

import model.DrawingModel;
import shapes.Command;

public class DeletePoint implements Command {
	
	private DrawingModel model;
	private Point point;
	
	public DeletePoint(DrawingModel d, Point p) {
		this.model = d;
		this.point = p;
	}
	@Override
	public void execute() {
		model.deleteShape(point);
	}

	@Override
	public void unexecute() {
		model.addShape(point);
	}

}