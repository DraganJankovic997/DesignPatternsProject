package log;

import java.awt.Color;

import frame.AppFrame;
import model.DrawingModel;
import shapes.Command;
import shapes.Shape;
import shapes.circle.AddCircle;
import shapes.circle.Circle;
import shapes.circle.DeleteCircle;
import shapes.circle.UpdateCircle;
import shapes.hexagon.AddHexagonAdapter;
import shapes.hexagon.DeleteHexagonAdapter;
import shapes.hexagon.HexagonAdapter;
import shapes.hexagon.UpdateHexagonAdapter;
import shapes.line.AddLine;
import shapes.line.DeleteLine;
import shapes.line.Line;
import shapes.line.UpdateLine;
import shapes.point.AddPoint;
import shapes.point.DeletePoint;
import shapes.point.Point;
import shapes.point.UpdatePoint;
import shapes.rectangle.AddRectangle;
import shapes.rectangle.DeleteRectangle;
import shapes.rectangle.Rectangle;
import shapes.rectangle.UpdateRectangle;
import shapes.square.AddSquare;
import shapes.square.DeleteSquare;
import shapes.square.Square;
import shapes.square.UpdateSquare;

public class ToCommand {
	private DrawingModel model;
	private AppFrame frame;
	public ToCommand(DrawingModel d,AppFrame f) {
		this.model=d;
		this.frame=f;
	}
	
	public Command transform(String s) {
		String className, state, s1, s2;
		Command finalCommand = null;
		String[] sSplit = s.split("_");
		
		className = sSplit[0];
		state = sSplit[1];
		s1 = sSplit[2];
		if(sSplit.length > 3) s2 = sSplit[4];
		else s2 = null;
		
		
		Shape sh = null;
		
		String[] firstShapeSplit = s1.split("\\(");
		if(s2 != null) {
			s2 = s2.split("\\(")[1];
			s2 = s2.substring(0, s2.length() - 1);
		}
		
		if(firstShapeSplit[0].equals("Point")) {
			String ps = firstShapeSplit[1];
			Point p = toPoint(ps.substring(0, ps.length() - 1));
			sh = p;
			if(className.equals("AddPoint")) finalCommand = new AddPoint(model, p);
			else if (className.equals("DeletePoint")) finalCommand = new DeletePoint(model, p);
			else if (className.equals("UpdatePoint")) finalCommand = new UpdatePoint(p, toPoint(s2));
		} else if(firstShapeSplit[0].equals("Line")) {
			String ls = firstShapeSplit[1];
			Line l = toLine(ls.substring(0, ls.length() - 1));
			sh = l;
			if(className.equals("AddLine")) finalCommand = new AddLine(model, l);
			else if(className.equals("DeleteLine")) finalCommand = new DeleteLine(model, l);
			else if(className.equals("UpdateLine")) finalCommand = new UpdateLine(l, toLine(s2));
		} else if(firstShapeSplit[0].equals("Square")) {
			String ss = firstShapeSplit[1];
			Square sq = toSquare(ss.substring(0, ss.length()-1));
			sh = sq;
			if(className.equals("AddSquare")) finalCommand = new AddSquare(model, sq);
			else if(className.equals("DeleteSquare")) finalCommand = new DeleteSquare(model, sq);
			else if(className.equals("UpdateSquare")) finalCommand = new UpdateSquare(sq, toSquare(s2));
		} else if(firstShapeSplit[0].equals("Rectangle")) {
			String ss = firstShapeSplit[1];
			Rectangle r = toRectangle(ss.substring(0, ss.length()-1));
			sh = r;
			if(className.equals("AddRectangle")) finalCommand = new AddRectangle(model, r);
			else if(className.equals("DeleteRectangle")) finalCommand = new DeleteRectangle(model, r);
			else if(className.equals("UpdateRectangle")) finalCommand = new UpdateRectangle(r, toRectangle(s2));
		} else if(firstShapeSplit[0].equals("Circle")) {
			String ss = firstShapeSplit[1];
			Circle c = toCircle(ss.substring(0, ss.length()-1));
			sh = c;
			if(className.equals("AddCircle")) finalCommand = new AddCircle(model, c);
			else if(className.equals("DeleteCircle")) finalCommand = new DeleteCircle(model, c);
			else if(className.equals("UpdateCircle")) finalCommand = new UpdateCircle(c, toCircle(s2));
		} else if(firstShapeSplit[0].equals("HexagonAdapter")) {
			String ss = firstShapeSplit[1];
			HexagonAdapter h = toHexagonAdapter(ss.substring(0, ss.length()-1));
			sh = h;
			if(className.equals("AddHexagonAdapter")) finalCommand = new AddHexagonAdapter(model, h);
			else if(className.equals("DeleteHexagonAdapter")) finalCommand = new DeleteHexagonAdapter(model, h);
			else if(className.equals("UpdateHexagonAdapter")) finalCommand = new UpdateHexagonAdapter(h, toHexagonAdapter(s2));
		}
		
		return finalCommand;
	}

	private Color parseColor(String boja) {
		boja = boja.substring(1);
		boja = boja.substring(0, boja.length()-1);
		String[] boje = boja.split("-");
		return new Color(Integer.parseInt(boje[0]), Integer.parseInt(boje[1]), Integer.parseInt(boje[2]));
	}
	
	private Point toPoint(String substring) {
		String[] split = substring.split(",");
		int x = Integer.parseInt(split[0].split("=")[1]);
		int y = Integer.parseInt(split[1].split("=")[1]);
		Color c = parseColor(split[2].split("=")[1]);
		boolean s = Boolean.parseBoolean(split[3].split("=")[1]);
		Point p = new Point(x, y, c);
		p.setSelected(s);
		return p;
	}
	
	private Line toLine(String substring) {
		String[] split = substring.split(",");
		int sx=Integer.parseInt(split[0].split("=")[1]);
		int sy=Integer.parseInt(split[1].split("=")[1]);
		int ex=Integer.parseInt(split[2].split("=")[1]);
		int ey=Integer.parseInt(split[3].split("=")[1]);
		Color c=parseColor(split[4].split("=")[1]);
		boolean s=Boolean.parseBoolean(split[5].split("=")[1]);
		Line l=new Line(new Point(sx,sy),new Point(ex,ey),c);
		l.setSelected(s);
		return l;
	}
	
	private Square toSquare(String substring) {
		String[] split = substring.split(",");
		int x=Integer.parseInt(split[0].split("=")[1]);
		int y=Integer.parseInt(split[1].split("=")[1]);
		int w=Integer.parseInt(split[2].split("=")[1]);
		Color oc=parseColor(split[3].split("=")[1]);
		Color ic=parseColor(split[4].split("=")[1]);
		boolean s=Boolean.parseBoolean(split[5].split("=")[1]);
		Square sq=new Square(new Point(x,y), w, oc, ic);
		sq.setSelected(s);
		return sq;
	}
	
	private Rectangle toRectangle(String substring) {
		String[] split = substring.split(",");
		int x=Integer.parseInt(split[0].split("=")[1]);
		int y=Integer.parseInt(split[1].split("=")[1]);
		int h=Integer.parseInt(split[2].split("=")[1]);
		int w=Integer.parseInt(split[3].split("=")[1]);
		Color oc=parseColor(split[4].split("=")[1]);
		Color ic=parseColor(split[5].split("=")[1]);
		boolean s=Boolean.parseBoolean(split[6].split("=")[1]);
		Rectangle r=new Rectangle(new Point(x,y), h, w, oc, ic);
		r.setSelected(s);
		return r;
	}
	
	private Circle toCircle(String substring) {
		String[] split = substring.split(",");
		int x=Integer.parseInt(split[0].split("=")[1]);
		int y=Integer.parseInt(split[1].split("=")[1]);
		int r=Integer.parseInt(split[2].split("=")[1]);
		Color oc=parseColor(split[3].split("=")[1]);
		Color ic=parseColor(split[4].split("=")[1]);
		boolean s=Boolean.parseBoolean(split[5].split("=")[1]);
		Circle c=new Circle(new Point(x,y), r, oc, ic);
		c.setSelected(s);
		return c;
	}
	
	private HexagonAdapter toHexagonAdapter(String substring) {
		String[] split = substring.split(",");
		int x=Integer.parseInt(split[0].split("=")[1]);
		int y=Integer.parseInt(split[1].split("=")[1]);
		int r=Integer.parseInt(split[2].split("=")[1]);
		Color oc=parseColor(split[3].split("=")[1]);
		Color ic=parseColor(split[4].split("=")[1]);
		boolean s=Boolean.parseBoolean(split[5].split("=")[1]);
		HexagonAdapter h=new HexagonAdapter(new hexagon.Hexagon(x, y, r), oc, ic);
		h.setSelected(s);
		return h;
	}
}
