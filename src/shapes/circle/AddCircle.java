package shapes.circle;

import model.DrawingModel;
import shapes.Command;

public class AddCircle implements Command {

	private static final long serialVersionUID = 1051819297990149860L;
	private DrawingModel model;
	private Circle circle;
	
	public AddCircle(DrawingModel d, Circle c) {
		this.model = d;
		this.circle = c;
	}
	
	@Override
	public void execute() {
		model.addShape(circle);
	}

	@Override
	public void unexecute() {
		model.deleteShape(circle);
	}

}
