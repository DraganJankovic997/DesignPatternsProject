package shapes.point;

import shapes.Command;

public class UpdatePoint implements Command {

	private static final long serialVersionUID = 5051409597490174150L;
	private Point oldPoint, newPoint, currentPoint;
	
	public UpdatePoint(Point cp, Point np) {
		this.currentPoint = cp;
		this.newPoint = np;
	}
	
	@Override
	public void execute() {
		oldPoint = (Point) currentPoint.clone();
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
