package position;

import java.util.Collections;

import model.DrawingModel;
import shapes.Command;
import shapes.Shape;

public class BackCommand implements Command {

	private static final long serialVersionUID = -9062710313518987403L;
	private DrawingModel model;
	private Shape shape;
	private int oldIndex;
	
	public BackCommand(DrawingModel d, Shape s) {
		this.model = d;
		this.shape = s;
		this.oldIndex = model.getShapes().indexOf(shape);
	}
	
	@Override
	public void execute() {
		if(oldIndex != -1 && model.getShapes().indexOf(shape) != -1)Collections.swap(model.getShapes(), oldIndex, oldIndex - 1);
	}

	@Override
	public void unexecute() {
		if(oldIndex != -1 && model.getShapes().indexOf(shape) != -1)Collections.swap(model.getShapes(), model.getShapes().indexOf(shape) , oldIndex);
	}

}
