package shapes.square;

import model.DrawingModel;
import shapes.Command;

public class AddSquare implements Command {

	private DrawingModel model;
	private Square square;
	
	public AddSquare(DrawingModel d, Square s) {
		this.model = d;
		this.square = s;
	}
	
	@Override
	public void execute() {
		model.addShape(square);
	}

	@Override
	public void unexecute() {
		model.deleteShape(square);
	}

}
