package shapes.hexagon;

import shapes.Command;

public class UpdateHexagonAdapter implements Command {

	private HexagonAdapter oldHa, newHa, curHa;
	
	public UpdateHexagonAdapter(HexagonAdapter ch, HexagonAdapter nh) {
		this.curHa = ch;
		this.newHa = nh;
	}
	
	@Override
	public void execute() {
		oldHa = (HexagonAdapter) curHa.clone();
		curHa.setHexagon(newHa.getHexagon());
		curHa.setColor(newHa.getColor());
		curHa.setInnerColor(newHa.getInnerColor());
		curHa.setSelected(newHa.isSelected());
	}

	@Override
	public void unexecute() {
		curHa.setHexagon(oldHa.getHexagon());
		curHa.setColor(oldHa.getColor());
		curHa.setInnerColor(oldHa.getInnerColor());
		curHa.setSelected(oldHa.isSelected());
	}

}
