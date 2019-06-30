package shapes.circle;

import model.DrawingModel;
import shapes.Command;

public class DeleteCircle implements Command {

	private DrawingModel model;
	private Circle circle;
	
	public DeleteCircle(DrawingModel d, Circle c) {
		this.model = d;
		this.circle = c;
	}
	
	@Override
	public void execute() {
		model.deleteShape(circle);
	}

	@Override
	public void unexecute() {
		model.addShape(circle);
	}

}
