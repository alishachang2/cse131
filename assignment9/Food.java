package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	// instance variable
	public static final double FOOD_SIZE = 0.02;
	private double x, y;

	// getters
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	/**
	 * Creates a new Food at a random location
	 */
	//constructor
	public Food() {
		boolean withinBounds = false;
		while (!withinBounds) {
			double xValue = Math.random();
			double yValue = Math.random();
			if (xValue > FOOD_SIZE && xValue < (1.0 - FOOD_SIZE) && yValue > FOOD_SIZE && yValue < 1.0 - FOOD_SIZE) {
				x = xValue;
				y = yValue;
				withinBounds = true;
			}
		}
	}

	/**
	 * Draws the Food
	 */
	public void draw() {
		Color hotPink = new Color(232, 42, 108);
		StdDraw.setPenColor(hotPink);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
}
