package shapes.rectangle;

import model.DrawingModel;
import shapes.Command;

public class DeleteRectangle implements Command {

	private DrawingModel model;
	private Rectangle rectangle;
	
	public DeleteRectangle(DrawingModel d, Rectangle r) {
		this.model = d;
		this.rectangle = r;
	}
	@Override
	public void execute() {
		model.deleteShape(rectangle);
	}

	@Override
	public void unexecute() {
		model.addShape(rectangle);
	}

}
