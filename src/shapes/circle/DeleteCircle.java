package shapes.circle;

import model.DrawingModel;
import shapes.Command;

public class DeleteCircle implements Command {

	private static final long serialVersionUID = 1051411297990149860L;
	private DrawingModel model;
	private Circle circle;
	private int oldPosition;
	
	public DeleteCircle(DrawingModel d, Circle c) {
		this.model = d;
		this.circle = c;
		this.oldPosition = model.getShapes().indexOf(circle);
	}
	
	@Override
	public void execute() {
		model.deleteShape(circle);
	}

	@Override
	public void unexecute() {
		model.insertInto(circle, oldPosition);
	}

}
