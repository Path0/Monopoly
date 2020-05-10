package designs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class Car extends JPanel {
	private double scaleModifier;
	private int width;
	private int height;
	
	private Dimension[] n1,n6,n6i;
	private Rectangle n2,n4,n5,n7;
	private Polygon n3;
	private Dimension[] l2,l3,l4,l5,l6;

	/**
	 * Create the frame.
	 */
	public Car(int height) {
		this.height = height;
		scaleModifier = (double) height / 8;
		this.width = (int) (height * (7.0/8.0));
		this.setSize(width + 1, height + 1);
		makePolygons();
	}
	
	
	
	public void makePolygons() {
		n1 = makeOval(3.5,1,2.5,1);
		n2 = makeRectangle(1, 1, 5, 4);
		n3 = makeTrapezoid(6, 5, 7, 6, 0, 6, 1, 5);
		n4 = makeRectangle(1,6,1,2);
		n5 = makeRectangle(5,6,1,2);
		n6 = makeCircle(3.5,4.5,1);
		n6i = makeCircle(3.5,4.5,0.5);
		n7 = makeRectangle(2,2,3,1);
		
		l2 = makeLine(1,1,1,5);
		l3 = makeLine(1,5,0,6);
		l4 = makeLine(0,6,7,6);
		l5 = makeLine(7,6,6,5);
		l6 = makeLine(6,5,6,1);
		
	}
	
	public void paintComponent(Graphics g) {
		 g.setColor(Color.RED);
		 g.fillOval(n1[0].width, n1[0].height, n1[1].width, n1[1].height);
		 g.fillRect(n2.x,n2.y, n2.width, n2.height);
		 g.fillPolygon(n3);
		 g.setColor(Color.WHITE);
		 g.fillRect(n4.x, n4.y, n4.width, n4.height);
		 g.fillRect(n5.x, n5.y, n5.width, n5.height);
		 g.fillOval(n6[0].width, n6[0].height, n6[1].width, n6[1].height);
		 g.fillRect(n7.x, n7.y, n7.width, n7.height);
		 
		 g.setColor(Color.BLACK);
		 g.drawArc(n1[0].width, n1[0].height, n1[1].width, n1[1].height, 0, 180);
		 g.drawLine(l2[0].width, l2[0].height, l2[1].width, l2[1].height);
		 g.drawLine(l3[0].width, l3[0].height, l3[1].width, l3[1].height);
		 g.drawRect(n4.x, n4.y, n4.width, n4.height);
		 g.drawRect(n5.x, n5.y, n5.width, n5.height);
		 g.drawLine(l4[0].width, l4[0].height, l4[1].width, l4[1].height);
		 g.drawOval(n6[0].width, n6[0].height, n6[1].width, n6[1].height);
		 g.drawOval(n6i[0].width, n6i[0].height, n6i[1].width, n6i[1].height);
		 g.drawRect(n7.x, n7.y, n7.width, n7.height);
		 g.drawLine(l5[0].width, l5[0].height, l5[1].width, l5[1].height);
		 g.drawLine(l6[0].width, l6[0].height, l6[1].width, l6[1].height);
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


