package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment extends ColorUtils {

	// instance variables
	private double x, y, size;
	private Color color;

	// constructor
	public BodySegment(double x, double y, double size) {
		this.x = x;
		this.y = y;
		this.size = size;
		color = solidColor();
	}

	// Draws the segment
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x, y, size);
	}

	// getters
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	// setters
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}

}
