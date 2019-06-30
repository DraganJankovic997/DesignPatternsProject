package shapes.point;

import shapes.Command;

public class UpdatePoint implements Command {

	private Point oldPoint, newPoint, currentPoint;
	
	public UpdatePoint(Point cp, Point np) {
		this.currentPoint = cp;
		this.newPoint = np;
	}
	
	@Override
	public void execute() {
		this.oldPoint = new Point(currentPoint.getX(), currentPoint.getY(), currentPoint.getColor());
		oldPoint.setSelected(currentPoint.isSelected());
		currentPoint.setX(newPoint.getX());
		currentPoint.setY(newPoint.getY());
		currentPoint.setColor(newPoint.getColor());
		currentPoint.setSelected(newPoint.isSelected());
	}

	@Override
	public void unexecute() {
		currentPoint.setX(oldPoint.getX());
		currentPoint.setY(oldPoint.getY());
		currentPoint.setColor(oldPoint.getColor());
		currentPoint.setSelected(oldPoint.isSelected());
	}

}
