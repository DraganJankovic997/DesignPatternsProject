package shapes.line;

import shapes.Command;

public class UpdateLine implements Command{

	private Line oldLine, newLine, currentLine;
	
	public UpdateLine(Line cl, Line nl) {
		this.currentLine = cl;
		this.newLine = nl;
	}
	
	
	@Override
	public void execute() {
		oldLine = new Line(currentLine.getStartPoint(), currentLine.getEndPoint(), currentLine.getColor());
		oldLine.setSelected(currentLine.isSelected());
		currentLine.setStartPoint(newLine.getStartPoint());
		currentLine.setEndPoint(newLine.getEndPoint());
		currentLine.setColor(newLine.getColor());
		currentLine.setSelected(newLine.isSelected());
	}

	@Override
	public void unexecute() {
		currentLine.setStartPoint(oldLine.getStartPoint());
		currentLine.setEndPoint(oldLine.getEndPoint());
		currentLine.setColor(oldLine.getColor());
		currentLine.setSelected(oldLine.isSelected());
	}

}
