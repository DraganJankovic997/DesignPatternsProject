package position;

import java.util.Collections;

import model.DrawingModel;
import shapes.Command;
import shapes.Shape;

public class BringToFrontCommand implements Command {

	private static final long serialVersionUID = -9062790343518987403L;
	private DrawingModel model;
	private Shape shape;
	private int oldIndex;
	
	public BringToFrontCommand(DrawingModel d, Shape s) {
		this.model = d;
		this.shape = s;
		this.oldIndex = model.getShapes().indexOf(shape);
	}

	@Override
	public void execute() {
		if(this.oldIndex < model.getShapes().size() - 1) {
			Collections.swap(model.getShapes(), this.oldIndex, model.getShapes().size()-1);
		}
	}

	@Override
	public void unexecute() {
		if(this.oldIndex < model.getShapes().size() - 1) {
			Collections.swap(model.getShapes(), model.getShapes().size() - 1, this.oldIndex);
		}
	}

}
