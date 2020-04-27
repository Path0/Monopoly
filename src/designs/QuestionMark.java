package designs;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.function.Consumer;

import javax.swing.JPanel;

public class QuestionMark extends JPanel {
	public double scaleModifier;
	public int height, width;
	
	
	public Dimension[] n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13,n14;
	/**
	 * Create the panel.
	 */
	public QuestionMark(int height) {
		scaleModifier = (double) height / 29;
		makePolygons();
		int width =  (int) (height * ( (double) 18/29) );
		
		this.setSize(width+1,height+1);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Consumer<Dimension[]> drawLine = n -> {
			g.drawLine(n[0].width, n[0].height, n[1].width, n[1].height);
		};
		
		g.drawArc(n1[0].width, n1[0].height, n1[1].width, n1[1].height, 0, 162);
		g.drawArc(n2[0].width, n2[0].height, n2[1].width, n2[1].height, 0, 180);
		g.drawOval(n14[0].width, n14[0].height, n14[1].width, n14[1].height);
		
		drawLine.accept(n3);
		drawLine.accept(n4);
		drawLine.accept(n5);
		drawLine.accept(n6);
		drawLine.accept(n7);
		drawLine.accept(n8);
		drawLine.accept(n9);
		drawLine.accept(n10);
		drawLine.accept(n11);
		drawLine.accept(n12);
		drawLine.accept(n13);
		
		
	}
	
	public void makePolygons() {
		n1 = makeCircle(9,9,9);
		n2 = makeOval(9, 6, 3, 2);
		n3 = makeLine(0,6,6,6);
		n4 = makeLine(12,6,12,9);
		n5 = makeLine(12,9,11,11);
		n6 = makeLine(11,11,8,14);
		n7 = makeLine(8,14,7,16);
		n8 = makeLine(7,16,7,22);
		n9 = makeLine(7,22,13,22);
		n10 = makeLine(13,22,13,16);
		n11 = makeLine(13,16,14,14);
		n12 = makeLine(14,14,17,11);
		n13 = makeLine(17,11,18,9);
		n14 = makeCircle(10,26,3);
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
