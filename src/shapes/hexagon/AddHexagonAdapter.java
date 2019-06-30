package shapes.hexagon;

import model.DrawingModel;
import shapes.Command;

public class AddHexagonAdapter implements Command {

	private DrawingModel model;
	private HexagonAdapter ha;
	
	public AddHexagonAdapter(DrawingModel d, HexagonAdapter h) {
		this.model = d;
		this.ha = h;
	}
	
	@Override
	public void execute() {
		model.addShape(ha);
	}

	@Override
	public void unexecute() {
		model.deleteShape(ha);
	}

}
