package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
//	int segmentCount = getSegmentCount();

	public Snake() {
		segments = new LinkedList<>();
		segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));
		// FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
	}

	public void changeDirection(int direction) {
		if (direction == 1) { // up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { // down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { // left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { // right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}

	/**
	 * Moves the snake by updating the position of each of the segments based on the
	 * current direction of travel
	 */
	public void move() {
		BodySegment head = segments.getFirst();
		double newHeadX = head.getX() + deltaX;
		double newHeadY = head.getY() + deltaY;
		for (int i = segments.size() - 1; i > 0; i--) {
			BodySegment current = segments.get(i);
			BodySegment previous = segments.get(i - 1);
			current.setPosition(previous.getX(), previous.getY());
		}
		head.setPosition(newHeadX, newHeadY);
	}

	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment segment : segments) {
			segment.draw();
		}
	}

	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * 
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		BodySegment head = segments.getFirst();
		double distance = Math.pow((head.getX() - f.getX()), 2) + Math.pow((head.getY() - f.getY()), 2);
		if (distance < Math.pow((SEGMENT_SIZE + Food.FOOD_SIZE), 2)) {
			BodySegment tail = segments.getLast();
			segments.add(new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE));
			return true;
		}
		return false;
	}

	/**
	 * Returns true if the head of the snake is in bounds
	 * 
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		BodySegment head = segments.getFirst();
		return head.getX() >= SEGMENT_SIZE && head.getX() <= 1 - SEGMENT_SIZE && head.getY() >= SEGMENT_SIZE && head.getY() <= 1 - SEGMENT_SIZE;
	}
	
	public int getSegmentCount() {
		return segments.size();
	}
}

