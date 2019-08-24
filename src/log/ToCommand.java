package log;

import java.awt.Color;

import frame.AppFrame;
import model.DrawingModel;
import position.BackCommand;
import position.BringToBackCommand;
import position.BringToFrontCommand;
import position.FrontCommand;
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
		
		if(className.equals("BackCommand") || className.equals("FrontCommand") 
				|| className.equals("BringToBackCommand") || className.equals("BringToFrontCommand")) {
			Shape sh1 = null;
			String shapeString = firstShapeSplit[1];
			 
			if(firstShapeSplit[0].equals("Point")) sh1 = toPoint(shapeString.substring(0, shapeString.length() - 1));
			else if(firstShapeSplit[0].equals("Line")) sh1 = toLine(shapeString.substring(0, shapeString.length() - 1));
			else if(firstShapeSplit[0].equals("Square")) sh1 = toSquare(shapeString.substring(0, shapeString.length() - 1));
			else if(firstShapeSplit[0].equals("Rectangle")) sh1 = toRectangle(shapeString.substring(0, shapeString.length() - 1));
			else if(firstShapeSplit[0].equals("Circle")) sh1 = toCircle(shapeString.substring(0, shapeString.length() - 1));
			else if(firstShapeSplit[0].equals("HexagonAdapter")) sh1 = toHexagonAdapter(shapeString.substring(0, shapeString.length() - 1));
			
			Shape realModel = check(sh1);

			
			if(className.equals("BackCommand")) finalCommand = new BackCommand(model, realModel);
			else if(className.equals("FrontCommand")) finalCommand = new FrontCommand(model, realModel);
			else if(className.equals("BringToBackCommand")) finalCommand = new BringToBackCommand(model, realModel);
			else if(className.equals("BringToFrontCommand")) finalCommand = new BringToFrontCommand(model, realModel);
				
		} else {
			//nije pozicija 
			
			
			if(s2 != null) {
				s2 = s2.split("\\(")[1];
				s2 = s2.substring(0, s2.length() - 1);
			}
			
			if(firstShapeSplit[0].equals("Point")) {
				String ps = firstShapeSplit[1];
				Point p = toPoint(ps.substring(0, ps.length() - 1));
				Point p2 = null;
				if(s2 != null) {
					p2 = toPoint(s2);
					
				}
				sh = p;
				if(className.equals("AddPoint")) finalCommand = new AddPoint(model, p);
				else if (className.equals("DeletePoint")) finalCommand = new DeletePoint(model, p);
				else if (className.equals("UpdatePoint")) {
					Point realPoint = (Point) check(p);
					finalCommand = new UpdatePoint(realPoint, p2);
				}
			} else if(firstShapeSplit[0].equals("Line")) {
				String ls = firstShapeSplit[1];
				Line l = toLine(ls.substring(0, ls.length() - 1));
				sh = l;
				Line l2 =null;
				if(s2!=null) {
					l2 = toLine(s2);					
				}
				if(className.equals("AddLine")) finalCommand = new AddLine(model, l);
				else if(className.equals("DeleteLine")) finalCommand = new DeleteLine(model, l);
				else if(className.equals("UpdateLine")) {
					Line realLine = (Line) check(l);
					finalCommand = new UpdateLine(realLine, l2);
				}
			} else if(firstShapeSplit[0].equals("Square")) {
				String ss = firstShapeSplit[1];
				Square sq = toSquare(ss.substring(0, ss.length()-1));
				sh = sq;
				Square sq2 = null;
				if(s2!=null) {
					sq2 = toSquare(s2);
				}
				if(className.equals("AddSquare")) finalCommand = new AddSquare(model, sq);
				else if(className.equals("DeleteSquare")) finalCommand = new DeleteSquare(model, sq);
				else if(className.equals("UpdateSquare")){
					Square realSquare = (Square) check(sq);
					finalCommand = new UpdateSquare(realSquare, sq2);
				}
			} else if(firstShapeSplit[0].equals("Rectangle")) {
				String ss = firstShapeSplit[1];
				Rectangle r = toRectangle(ss.substring(0, ss.length()-1));
				sh = r;
				Rectangle r2 = null;
				if(s2 != null) {
					r2 = toRectangle(s2);
					
				}
				if(className.equals("AddRectangle")) finalCommand = new AddRectangle(model, r);
				else if(className.equals("DeleteRectangle")) finalCommand = new DeleteRectangle(model, r);
				else if(className.equals("UpdateRectangle")) {
					Rectangle realRectangle = (Rectangle) check(r);
					finalCommand = new UpdateRectangle(realRectangle, r2);
				}
			} else if(firstShapeSplit[0].equals("Circle")) {
				String ss = firstShapeSplit[1];
				Circle c = toCircle(ss.substring(0, ss.length()-1));
				sh = c;
				Circle c2 = null;
				if(s2 != null) {
					c2 = toCircle(s2);
					
				}
				if(className.equals("AddCircle")) finalCommand = new AddCircle(model, c);
				else if(className.equals("DeleteCircle")) finalCommand = new DeleteCircle(model, c);
				else if(className.equals("UpdateCircle")) {
					Circle realCircle = (Circle) check(c);
					finalCommand = new UpdateCircle(realCircle, c2);
				}
			} else if(firstShapeSplit[0].equals("HexagonAdapter")) {
				String ss = firstShapeSplit[1];
				HexagonAdapter h = toHexagonAdapter(ss.substring(0, ss.length()-1));
				sh = h;
				HexagonAdapter h2 = null;
				if(s2 != null) {
					h2 = toHexagonAdapter(s2);
				}
				if(className.equals("AddHexagonAdapter")) finalCommand = new AddHexagonAdapter(model, h);
				else if(className.equals("DeleteHexagonAdapter")) finalCommand = new DeleteHexagonAdapter(model, h);
				else if(className.equals("UpdateHexagonAdapter")) {
					HexagonAdapter realHexagonAdapter = (HexagonAdapter) check(h);
					finalCommand = new UpdateHexagonAdapter(realHexagonAdapter, h2);
				}
			}
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
	
	
	private Shape check(Shape forCheck) {
		Shape sh = null;
		for(Shape var : model.getShapes()) 
		{ 
			if(var.equals(forCheck) == true) sh = var;
		}
		return sh;
	}
	
	
	
	
	
}
