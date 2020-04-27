package designs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class LightBulb extends JPanel {
	
	public double scaleModifier;
	
	public Dimension[] n1; //circle on top
	public Polygon n2; // trapezoid
	public Dimension[] n3; // the rest of these are gonna be just lines
	public Dimension[] n4;
	public Dimension[] n5;
	public Dimension[] n6;
	public Dimension[] n7;
	public Dimension[][] lines;
	/**
	 * Create the panel.
	 */
	public LightBulb(int height) {
		scaleModifier = (double) height / 12; //scale is the height divided by the coordinate's height.
		makePolygons();
		lines = new Dimension[][] {n3,n4,n5,n6,n7};
		int width = (int) ((6.0 / 12) * height);
		
		this.setSize(width,height);
		this.setVisible(true);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(n1[0].width, n1[0].height, n1[1].width, n1[1].height);
		g.fillPolygon(n2);
		g.setColor(Color.BLACK);
		g.drawOval(n1[0].width, n1[0].height, n1[1].width, n1[1].height);
		g.drawPolygon(n2);
		//draws the lines with for loop
		for(Dimension[] x : lines) {
			g.drawLine(x[0].width, x[0].height, x[1].width, x[1].height);
		}
	}
	
	public void makePolygons() {
		n1 = makeCircle(3.0,3.0,3.0);
		n2 = makeTrapezoid(0,3,6,3,5,8,1,8);
		n3 = makeLine(5,9,1,10);
		n4 = makeLine(5,10,1,11);
		n5 = makeLine(5,11,1,12);
		n6 = makeLine(2,8,2,12);
		n7 = makeLine(4,8,4,12);
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
	public Polygon makeTrapezoid(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
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
	public Dimension[] makeLine(int x1, int y1, int x2, int y2) {
		Dimension a = new Dimension( scale(x1), scale(y1) );
		Dimension b = new Dimension( scale(x2), scale(y2) );
		return new Dimension[] {a,b};
	}
	
}
