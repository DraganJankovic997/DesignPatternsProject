package shapes.point;

import model.DrawingModel;
import shapes.Command;

public class DeletePoint implements Command {
	
	private static final long serialVersionUID = 1051409597590174150L;
	private DrawingModel model;
	private Point point;
	private int oldPosition;
	
	public DeletePoint(DrawingModel d, Point p) {
		this.model = d;
		this.point = p;
		this.oldPosition = model.getShapes().indexOf(point);
	}
	@Override
	public void execute() {
		model.deleteShape(point);
	}

	@Override
	public void unexecute() {
		model.insertInto(point, oldPosition);
	}

}