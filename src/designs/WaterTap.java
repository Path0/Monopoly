package designs;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class WaterTap extends JPanel {
	
	public double scaleModifier;
	
	public Dimension[] n1;
	public Dimension[] n2;
	public Dimension[] n3;
	public Dimension[] n4t; //top line
	public Dimension[] n4b; //bottom line
	public Dimension[] n5l; // left line
	public Dimension[] n5r; // right line
	public Polygon n6;
	public Dimension[] n7t; //top line
	public Dimension[] n7b; // bottom line
	public Dimension[] n8;
	public Dimension[] n9;
	public Dimension[] n10l; //left line
	public Dimension[] n10r; //right line
	public Dimension[] n10b; //bottom line
	public Dimension[] n11;
	public Dimension[] n12;
	
	public Dimension[][] lines;
	
	/**
	 * Create the panel.
	 */
	public WaterTap(int height) {
		scaleModifier = (double) height / 15; //scale is the height divided by the coordinate's height.
		makePolygons();
		lines = new Dimension[][] {n4t, n4b, n5l, n5r, n7t, n7b, n10l, n10r, n10b};
		int width = (int) ((24.0/15) * height);
		
		this.setSize(width+1,height+1); 
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawOval(n1[0].width, n1[0].height, n1[1].width, n1[1].height);
		g.drawOval(n2[0].width, n2[0].height, n2[1].width, n2[1].height);
		g.drawOval(n3[0].width, n3[0].height, n3[1].width, n3[1].height);
		
		for(Dimension[] x : lines) {
			g.drawLine(x[0].width, x[0].height, x[1].width, x[1].height);
		}
		
		g.drawPolygon(n6);
		
		g.drawArc(n8[0].width, n8[0].height, n8[1].width, n8[1].height, 24, (360-24-24));
		g.drawArc(n9[0].width, n9[0].height, n9[1].width, n9[1].height, 90, 180);
		g.drawArc(n11[0].width, n11[0].height, n11[1].width, n11[1].height, 0, 90);
		g.drawArc(n12[0].width, n12[0].height, n12[1].width, n12[1].height, 0, 90);
		
	}
	
	public void makePolygons() {
		n1 = makeCircle(8.0,1.0,1.0);
		n2 = makeCircle(14.0,1.0,1.0);
		n3 = makeCircle(11.0,1.0,0.5);
		n4t = makeLine(9,0.5,13,0.5);
		n4b = makeLine(9,1.5,13,1.5);
		n5l = makeLine(10.5,1.5,10.5,3);
		n5r = makeLine(11.5,1.5,11.5,3);
		n6 = makeTrapezoid(10.5,3,11.5,3,12,4,10,4);
		n7t = makeLine(2,4,17,4);
		n7b = makeLine(2,8,17,8);
		n8 = makeOval(2,6,2,5);
		n9 = makeOval(2,6,1,2);
		n10l = makeLine(20,11,20,15);
		n10r = makeLine(24,11,24,15);
		n10b = makeLine(20,15,24,15);
		n11 = makeCircle(17,11,3);
		n12 = makeCircle(17,11,7);
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


