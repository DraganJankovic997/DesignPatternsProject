package shapes.line;

import model.DrawingModel;
import shapes.Command;

public class DeleteLine implements Command {

	private static final long serialVersionUID = 1051416597990174160L;
	private DrawingModel model;
	private Line line;
	private int oldPosition;
	
	public DeleteLine(DrawingModel d, Line l) {
		this.model = d;
		this.line = l;
		this.oldPosition = model.getShapes().indexOf(line);
	}
	
	@Override
	public void execute() {
		model.deleteShape(line);
	}

	@Override
	public void unexecute() {
		model.insertInto(line, oldPosition);
	}
}
