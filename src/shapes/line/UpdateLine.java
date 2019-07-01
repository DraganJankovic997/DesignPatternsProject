package shapes.line;

import shapes.Command;

public class UpdateLine implements Command{

	private static final long serialVersionUID = 1051416597590174150L;
	private Line oldLine, newLine, currentLine;
	
	public UpdateLine(Line cl, Line nl) {
		this.currentLine = cl;
		this.newLine = nl;
	}
	
	
	@Override
	public void execute() {
		oldLine = (Line) currentLine.clone();
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
