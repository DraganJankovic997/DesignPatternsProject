package shapes.line;

import model.DrawingModel;
import shapes.Command;

public class DeleteLine implements Command {

	private static final long serialVersionUID = 1051416597990174160L;
	private DrawingModel model;
	private Line line;
	
	public DeleteLine(DrawingModel d, Line l) {
		this.model = d;
		this.line = l;
	}
	
	@Override
	public void execute() {
		model.deleteShape(line);
	}

	@Override
	public void unexecute() {
		model.addShape(line);
	}
}
