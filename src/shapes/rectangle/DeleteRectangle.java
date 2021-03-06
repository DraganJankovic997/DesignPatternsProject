package shapes.rectangle;

import model.DrawingModel;
import shapes.Command;

public class DeleteRectangle implements Command {

	private static final long serialVersionUID = 5051449597490174150L;
	private DrawingModel model;
	private Rectangle rectangle;
	private int oldPosition;
	
	public DeleteRectangle(DrawingModel d, Rectangle r) {
		this.model = d;
		this.rectangle = r;
		this.oldPosition = model.getShapes().indexOf(rectangle);
	}
	@Override
	public void execute() {
		model.deleteShape(rectangle);
	}

	@Override
	public void unexecute() {
		model.insertInto(rectangle, oldPosition);
	}

}
