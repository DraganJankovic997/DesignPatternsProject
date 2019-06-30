package shapes.square;

import shapes.Command;

public class UpdateSquare implements Command {

	private Square oldS, newS, curS;
	
	public UpdateSquare(Square cs, Square ns) {
		this.curS = cs;
		this.newS = ns;
	}
	
	@Override
	public void execute() {
		oldS = (Square) curS.clone();
		curS.setUpperLeftPoint(newS.getUpperLeftPoint());
		curS.setWidth(newS.getWidth());
		curS.setColor(newS.getColor());
		curS.setInnerColor(newS.getInnerColor());
		curS.setSelected(newS.isSelected());
	}

	@Override
	public void unexecute() {
		curS.setUpperLeftPoint(oldS.getUpperLeftPoint());
		curS.setWidth(oldS.getWidth());
		curS.setColor(oldS.getColor());
		curS.setInnerColor(oldS.getInnerColor());
		curS.setSelected(oldS.isSelected());
	}

}
