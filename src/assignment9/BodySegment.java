package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param size		size/radius of the segment
	 */
	public BodySegment(double x, double y, double size) {
		this.x=x;
		this.y=y;
		this.size=size;
		this.color = Color.green;
	}
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x, y, size);
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x=x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y=y;
	}
	
	public double getSize() {
		return size;
	}
	
	public void setSize(double size) {
		this.size=size;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}
