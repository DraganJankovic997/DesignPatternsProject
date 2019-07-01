package shapes.hexagon;

import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;
import shapes.Movable;
import shapes.Prototype;
import shapes.Shape;
import shapes.SurfaceShape;

public class HexagonAdapter extends SurfaceShape implements Movable, Prototype {

	private static final long serialVersionUID = 1051419197990174160L;
	private Hexagon hexagon;
	
	public HexagonAdapter(Hexagon h) {
		this.hexagon = h;
	}
	
	public HexagonAdapter(Hexagon h, Color c) {
		this.hexagon = h;
		this.setColor(c);
	}
	
	public HexagonAdapter(Hexagon h, Color c, Color ic) {
		this.hexagon = h;
		this.setColor(c);
		this.setInnerColor(ic);
	}
	
	@Override
	public void setColor(Color c) {
		super.setColor(c);
		hexagon.setBorderColor(c);
	}
	
	@Override
	public void setInnerColor(Color c) {
		super.setInnerColor(c);
		hexagon.setAreaColor(c);
	}
	
	public Hexagon getHexagon() {
		return hexagon;
	}

	public void setHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	
	public boolean isSelected() {
		return hexagon.isSelected();
	}

	@Override
	public int compareTo(Shape s) {
		if (s instanceof HexagonAdapter) {
			HexagonAdapter h = (HexagonAdapter) s;
			return hexagon.getR() - h.getHexagon().getR();
		} else return 0;
	}

	@Override
	public void moveTo(int x, int y) {
		hexagon.setX(x);
		hexagon.setY(y);
	}

	@Override
	public void moveFor(int x, int y) {
		hexagon.setX(hexagon.getX() + x);
		hexagon.setY(hexagon.getY() + y);
	}

	@Override
	public void fill(Graphics g) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean equals(Shape s) {
		if (s instanceof HexagonAdapter) {
			Hexagon h = ((HexagonAdapter) s).getHexagon();
			return hexagon.getX() == h.getX() && hexagon.getY() == h.getY()
					&& hexagon.getR() == h.getR();
		}
		return false;
	}

	@Override
	public void draw(Graphics g) {
		hexagon.paint(g);
	}

	@Override
	public void selected(Graphics g) {
		hexagon.setAreaColor(Color.BLUE);
	}

	//doesContain ne radi ?
	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}
	
	@Override
	public String toString() {
		return String.format("Hexagon(X=%d,Y=%d,r=%d,outercolor=[%d-%d-%d],innercolor=[%d-%d-%d],selected=%b)", this.getHexagon().getX(),
				this.getHexagon().getY(), this.getHexagon().getR(), getColor().getRed(), getColor().getGreen(), getColor().getBlue(),
				getInnerColor().getRed(), getInnerColor().getGreen(), getInnerColor().getBlue(),isSelected());
	}

	@Override
	public Shape clone() {
		Hexagon h = new Hexagon(this.getHexagon().getX(), this.getHexagon().getX(), this.getHexagon().getR());
		HexagonAdapter ha = new HexagonAdapter(h, this.getColor(), this.getInnerColor());
		ha.setSelected(this.isSelected());
		return ha;
	}
	
}
