package shapes.circle;

import shapes.Command;

public class UpdateCircle implements Command {

	private Circle oldC, newC, curC;
	
	public UpdateCircle(Circle cc, Circle nc) {
		this.curC = cc;
		this.newC = nc;
	}
	
	@Override
	public void execute() {
		oldC = (Circle) curC.clone();
		curC.setCenterPoint(newC.getCenterPoint());
		curC.setRadius(newC.getRadius());
		curC.setColor(newC.getColor());
		curC.setInnerColor(newC.getInnerColor());
		curC.setSelected(newC.isSelected());
	}

	@Override
	public void unexecute() {
		curC.setCenterPoint(oldC.getCenterPoint());
		curC.setRadius(oldC.getRadius());
		curC.setColor(oldC.getColor());
		curC.setInnerColor(oldC.getInnerColor());
		curC.setSelected(oldC.isSelected());
	}

}
