package designs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;

import javax.swing.JPanel;


public class Train extends JPanel {
	int height;
	int width;
	/**
	 * Scale constant so that I can put in raw coordinates that I mapped out on graph paper
	 * into the program and have it scale to the right pixel size.
	 */
	double scaleModifier;
	
	Polygon n1; // Bottom Smokestack
	Polygon n2; // Top Smokestack
	Rectangle n3; // Boiler
	Dimension[] n4; // back cutout
	Dimension[] n5; // front of train	
	Rectangle n6; // bottom cab
	Rectangle n7; // top cab
	Dimension[] n8; // curve cab
	Polygon n9; // snowplow
	Dimension[] n10; // front wheel
	Dimension[] n11; //back wheel
	
	
	/**
	 * Creates a new Train
	 * @param height height of the Train.
	 */
	public Train(int height) {
		scaleModifier = (double) height / 9;
		this.height = height;
		double factor = (double) 20/9;
		width = (int) ((double) height * factor);
		
		makePolygons();
		
		this.setSize(width,height);
		this.setVisible(true);
	}
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillPolygon(n1);
		g.fillPolygon(n2);
		g.fillRect(n3.x, n3.y, n3.width, n3.height);
		g.fillOval(n5[0].width, n5[0].height, n5[1].width, n5[1].height);
		g.fillRect(n6.x, n6.y, n6.width, n6.height);
		g.fillRect(n7.x, n7.y, n7.width, n7.height);
		g.fillOval(n8[0].width, n8[0].height, n8[1].width, n8[1].height);
		g.fillPolygon(n9);
		g.fillOval(n10[0].width, n10[0].height, n10[1].width, n10[1].height);
		g.fillOval(n11[0].width, n11[0].height, n11[1].width, n11[1].height);
		
		g.setColor(new Color(240,240,240));
		g.fillOval(n4[0].width, n4[0].height, n4[1].width, n4[1].height);
		g.setColor(Color.BLACK);
	}
	
	/**
	 * Makes the polygons, one at a time, using the methods below.
	 */
	public void makePolygons() {
		n1 = makeTrapezoid(3,1,6,1,5,4,4,4);
		n2 = makeTrapezoid(4,0,5,0,6,1,3,1);
		n3 = makeRectangle(2,4,12,3);
		n4 = makeCircle(16.5, 4.5,3);
		n5 = makeCircle(2.0,5.4,1.5);
		n6 = makeRectangle(11,2,4,2);
		n7 = makeRectangle(12,1,3,1);
		n8 = makeCircle(12,2,1);
		n9 = makeTrapezoid(3,7,4,7,3,9,1,9);
		n10 = makeCircle(6,7.9,1.5);
		n11 = makeCircle(12,7.9,1.5);
		
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

}
