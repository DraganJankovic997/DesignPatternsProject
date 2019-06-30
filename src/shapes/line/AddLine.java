package shapes.line;

import model.DrawingModel;
import shapes.Command;

public class AddLine implements Command {

	private DrawingModel model;
	private Line line;
	
	public AddLine(DrawingModel d, Line l) {
		this.model = d;
		this.line = l;
	}
	
	@Override
	public void execute() {
		model.addShape(line);
	}

	@Override
	public void unexecute() {
		model.deleteShape(line);
	}

}
