package shapes.square;

import model.DrawingModel;
import shapes.Command;

public class DeleteSquare implements Command {

	private static final long serialVersionUID = 3051449567490151150L;
	private DrawingModel model;
	private Square square;
	
	public DeleteSquare(DrawingModel d, Square s) {
		this.model = d;
		this.square = s;
	}
	
	@Override
	public void execute() {
		model.deleteShape(square);
	}

	@Override
	public void unexecute() {
		model.addShape(square);
	}

}
