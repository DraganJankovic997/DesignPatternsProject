package shapes.hexagon;

import model.DrawingModel;
import shapes.Command;

public class DeleteHexagonAdapter implements Command {

	private static final long serialVersionUID = 1051419197990174860L;
	private DrawingModel model;
	private HexagonAdapter ha;
	private int oldPosition;
	
	public DeleteHexagonAdapter(DrawingModel d, HexagonAdapter h) {
		this.model = d;
		this.ha = h;
		this.oldPosition = model.getShapes().indexOf(ha);
	}
	
	@Override
	public void execute() {
		model.deleteShape(ha);
	}

	@Override
	public void unexecute() {
		model.insertInto(ha, oldPosition);
	}

}
