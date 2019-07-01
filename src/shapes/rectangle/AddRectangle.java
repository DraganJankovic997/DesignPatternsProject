package shapes.rectangle;

import model.DrawingModel;
import shapes.Command;

public class AddRectangle implements Command {

	private static final long serialVersionUID = 3051851567490151150L;
	private DrawingModel model;
	private Rectangle rectangle;
	
	public AddRectangle(DrawingModel d, Rectangle r) {
		this.model = d;
		this.rectangle = r;
	}
	
	@Override
	public void execute() {
		model.addShape(rectangle);
	}

	@Override
	public void unexecute() {
		model.deleteShape(rectangle);
	}

}
