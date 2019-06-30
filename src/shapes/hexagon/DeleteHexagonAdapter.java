package shapes.hexagon;

import model.DrawingModel;
import shapes.Command;

public class DeleteHexagonAdapter implements Command {

	private DrawingModel model;
	private HexagonAdapter ha;
	
	public DeleteHexagonAdapter(DrawingModel d, HexagonAdapter h) {
		this.model = d;
		this.ha = h;
	}
	
	@Override
	public void execute() {
		model.deleteShape(ha);
	}

	@Override
	public void unexecute() {
		model.addShape(ha);
	}

}
