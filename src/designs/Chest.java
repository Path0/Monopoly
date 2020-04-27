package designs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.function.Consumer;

import javax.swing.JPanel;


public class Chest extends JPanel {
	private double scaleModifier;
	
	public Rectangle n1,n2;
	public Dimension[] n3,n4;
	
	/**
	 * Create the panel.
	 */
	public Chest(int height) {
		scaleModifier = (double) height / 9;
		int width = height;
		makePolygons();
		this.setSize(width + 1, height + 1);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Consumer<Dimension[]> drawLine = n -> {
			g.drawLine(n[0].width, n[0].height, n[1].width, n[1].height);
		};
	
		Consumer<Rectangle> drawRect = n-> {
			g.drawRect(n.x, n.y, n.width, n.height);
		};
		Consumer<Rectangle> fillRect = n-> {
			g.fillRect(n.x, n.y, n.width, n.height);
		};
		
		g.setColor(new Color(24,133,66));
		fillRect.accept(n1);
		g.setColor(new Color(18,176,168));
		fillRect.accept(n2);
		g.setColor(new Color(0,0,0));
		drawRect.accept(n1);
		drawRect.accept(n2);
		drawLine.accept(n3);
		drawLine.accept(n4);
		
	}
	
	public void makePolygons() {
		n1 = makeRectangle(0,0,9,9);
		n2 = makeRectangle(4,2,1,2);
		n3 = makeLine(0,3,4,3);
		n4 = makeLine(5,3,9,3);
	}
	
	/*
	 * ----UTIL METHODS----
	 */
	/**
	 * Makes a scaled Rectangle given points x,y, width, and height.
	 * @param x Coordinate X of the rectangle.
	 * @param y	Coordinate Y of the rectangle.
	 * @param width Coordinate width of the rectangle.
	 * @param height Coordinate height of the rectangle.
	 * @return <code>Rectangle</code> object containing the input data.
	 */
	public Rectangle makeRectangle(int x, int y, int width, int height) {
		int x1 = (int) (x * scaleModifier);
		int y1 = (int) (y * scaleModifier);
		int width1 = (int) (width * scaleModifier);
		int height1 = (int) (height * scaleModifier);
		return new Rectangle(x1,y1,width1,height1);
	}
	
	/**
	 * Makes a way to define circles using the <code>Dimension</code> class. Rather than inputting <code>Graphics</code>' 
	 * native starting point, width, height coordinate sytem, this implements the center-point, radius method for 
	 * creating circles. When making a new circle, use
	 * g.drawOval(x[0].width, x[0].height, x[1].width, x[1].height);. 
	 * x represents the <code>Dimension</code>[] array created by this method. 
	 * <strong>note:</strong> automatically scales the returned <code>Dimension</code>.
	 * @param midX Coordinate X of the center of this circle.
	 * @param midY Coordinate Y of the center of this circle.
	 * @param radius Radius of this circle.
	 * @return <code>Dimension</code>[] array containing the input data.
	 */
	public Dimension[] makeCircle(double midX, double midY, double radius) {
		int midX1 = scale(midX);
		int midY1 = scale(midY);
		int radius1 = scale(radius);
		
		int x = midX1 - radius1;
		int y = midY1 - radius1;
		Dimension start = new Dimension(x,y);
		Dimension dim = new Dimension(radius1*2, radius1*2);
		return new Dimension[] {start,dim};
	}
	
	/**
	 * There's a lot of parameters. Sorry. This basically just makes a <code>Polygon</code> given the input points. 
	 * In order for this to work correctly when <code>Graphics</code> draws this, you have to put the points in clockwise 
	 * (or counterclockwise, just be consistent) order. <strong>note:</strong> scales the input coordinates.
	 * @param x1 X1
	 * @param y1 Y1
	 * @param x2 X2
	 * @param y2 Y2
	 * @param x3 X3
	 * @param y3 Y3
	 * @param x4 X4
	 * @param y4 Y4
	 * @return <code>Polygon</code> contining the input data.
	 */
	public Polygon makeTrapezoid(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
		Polygon trapezoid = new Polygon();
		trapezoid.addPoint(scale(x1), scale(y1));
		trapezoid.addPoint(scale(x2), scale(y2));
		trapezoid.addPoint(scale(x3), scale(y3));
		trapezoid.addPoint(scale(x4), scale(y4));
		return trapezoid;
	}
	
	/**
	 * Scales the input coordinate n by the field scaleModifier.
	 * @param n Coordinate point to scale.
	 * @return Pixel coordinate.
	 */
	public int scale(int n) {
		double out = n * scaleModifier;
		return (int) out;
	}
	
	/**
	 * Scales the input coordinate n by the field scaleModifier.
	 * @param n for double cases when scaling needs to happen.
	 * @return Pixel coordinate.
	 */
	public int scale(double n) {
		double out = n * scaleModifier;
		return (int) out;
	}
	
	/**
	 * Makes a <code>Dimension</code>[] array from the line's input data. <strong>note:</strong> scales data.
	 * @param x1 X1
	 * @param y1 Y1
	 * @param x2 X2
	 * @param y2 Y2
	 * @return <code>Dimension</code>[] for the Line.
	 */
	public Dimension[] makeLine(double x1, double y1, double x2, double y2) {
		Dimension a = new Dimension(scale(x1), scale(y1));
		Dimension b = new Dimension(scale(x2), scale(y2));
		return new Dimension[] {a,b};
	}
	
	
	public Dimension[] makeOval(double midX, double midY, double widthRad, double heightRad) {
		int midX1 = scale(midX);
		int midY1 = scale(midY);
		int width1 = scale(widthRad);
		int height1 = scale(heightRad);
		
		int x = midX1 - width1;
		int y = midY1 - height1;
		Dimension start = new Dimension(x,y);
		Dimension dim = new Dimension(width1*2, height1*2);
		return new Dimension[] {start,dim};
	}
	
	
}
