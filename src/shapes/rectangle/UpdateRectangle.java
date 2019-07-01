package shapes.rectangle;

import shapes.Command;

public class UpdateRectangle implements Command {

	private static final long serialVersionUID = 5051449567490154150L;
	private Rectangle oldR, newR, curR;
	
	public UpdateRectangle(Rectangle cr, Rectangle nr) {
		this.curR = cr;
		this.newR = nr;
	}
	
	@Override
	public void execute() {
		oldR = (Rectangle) curR.clone();
		curR.setUpperLeftPoint(newR.getUpperLeftPoint());
		curR.setHeight(newR.getHeight());
		curR.setWidth(newR.getWidth());
		curR.setColor(newR.getColor());
		curR.setInnerColor(newR.getInnerColor());
		curR.setSelected(newR.isSelected());
	}

	@Override
	public void unexecute() {
		curR.setUpperLeftPoint(oldR.getUpperLeftPoint());
		curR.setHeight(oldR.getHeight());
		curR.setWidth(oldR.getWidth());
		curR.setColor(oldR.getColor());
		curR.setInnerColor(oldR.getInnerColor());
		curR.setSelected(oldR.isSelected());
	}

}
