package position;

import java.util.Collections;

import model.DrawingModel;
import shapes.Command;
import shapes.Shape;

public class FrontCommand implements Command {
	
	private static final long serialVersionUID = -9062290343518987403L;
	private DrawingModel model;
	private Shape shape;
	private int oldIndex;
	
	public FrontCommand(DrawingModel d, Shape s) {
		this.model = d;
		this.shape = s;
		this.oldIndex = model.getShapes().indexOf(shape);
	}
	@Override
	public void execute() {
		if(this.oldIndex < model.getShapes().size() - 1) {
			System.out.println(shape + "stari indeks " + this.oldIndex + "novi indeks : " + (this.oldIndex + 1));
			Collections.swap(model.getShapes(), this.oldIndex, this.oldIndex + 1);
			System.out.println(shape);
		}
		
	}

	@Override
	public void unexecute() {
		if(this.oldIndex < model.getShapes().size() - 1 ) {
			Collections.swap(model.getShapes(), this.oldIndex + 1, this.oldIndex);
		}
	}

}
