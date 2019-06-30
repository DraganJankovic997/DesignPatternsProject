package shapes.rectangle;

import shapes.Command;

public class UpdateRectangle implements Command {

	private Rectangle oldR, newR, curR;
	
	public UpdateRectangle(Rectangle cr, Rectangle nr) {
		this.curR = cr;
		this.newR = nr;
	}
	
	@Override
	public void execute() {
		oldR = new Rectangle(curR.getUpperLeftPoint(), curR.getHeight(), curR.getWidth(), curR.getColor(), curR.getInnerColor());
		oldR.setSelected(curR.isSelected());
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
