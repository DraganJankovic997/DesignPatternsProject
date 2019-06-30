package shapes.point;

import model.DrawingModel;
import shapes.Command;

public class AddPoint implements Command {

	private DrawingModel model;
	private Point point;
	
	public AddPoint(DrawingModel d, Point p) {
		this.model = d;
		this.point = p;
	}
	@Override
	public void execute() {
		model.addShape(point);
	}

	@Override
	public void unexecute() {
		model.deleteShape(point);
	}

}
