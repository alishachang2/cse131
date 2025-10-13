package assignment8;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.NotYetImplementedException;

public class Entity {
	private double x, y, speed;
	private boolean isAlive;
	private boolean isZombie;
	private double radius;

	public Entity() {
		this.x = 0;
		this.y = 0;
		this.isZombie = true;
		this.speed = 0;
		this.isAlive = true;
		this.radius = 0.008;
	}

	public Entity(double x, double y, boolean isZombie, double speed) {
		this.x = x;
		this.y = y;
		this.isZombie = isZombie;
		this.speed = speed;
		this.isAlive = true;
		this.radius = 0.008;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double d) {
		this.radius = d;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void wasConsumed() {
		isAlive = false;
	}

	public boolean isZombie() {
		return isZombie;
	}

	public double distanceCenterToPoint(double xOther, double yOther) {
		double dx = this.x - xOther;
		double dy = this.y - yOther;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double distanceCenterToCenter(Entity other) {
		return distanceCenterToPoint(other.getX(), other.getY());
	}

	public double distanceEdgeToEdge(double xOther, double yOther, double radiusOther) {
		double centerToCenterDistance = distanceCenterToPoint(xOther, yOther);
		return centerToCenterDistance - this.radius - radiusOther;
	}

	public double distanceEdgeToEdge(Entity other) {
		return distanceEdgeToEdge(other.getX(), other.getY(), other.getRadius());
	}

	public boolean isTouching(double xOther, double yOther, double radiusOther) {
		double centerToCenterDistance = distanceCenterToPoint(xOther, yOther);
		return centerToCenterDistance <= (this.radius + radiusOther);
	}

	public boolean isTouching(Entity other) {
		return isTouching(other.getX(), other.getY(), other.getRadius());
	}

	public void moveToward(double xOther, double yOther, double amount) {
		double xVector = xOther - getX();
		double yVector = yOther - getY();
		double angle = Math.atan2(yVector, xVector);
		double xAmount = amount * Math.cos(angle);
		double yAmount = amount * Math.sin(angle);

		this.x += xAmount;
		this.y += yAmount;

	}

	public void moveToward(Entity other) {
		moveToward(other.getX(), other.getY(), speed);
	}

	public void moveAwayFrom(double xOther, double yOther) {
		double xVector = getX() - xOther;
		double yVector = getY() - yOther;
		double oppositeX = getX() + xVector;
		double oppositeY = getY() + yVector;
		moveToward(oppositeX, oppositeY, speed);
	}

	public void moveAwayFrom(Entity other) {
		moveAwayFrom(other.getX(), other.getY());
	}

	private Entity findClosest(Entity[] entities, boolean includeZombies, boolean includeNonzombies) {
		Entity closest = null;
		double closestDist = Double.MAX_VALUE;
		for (Entity other : entities) {
			if (this != other && other != null && other.isAlive()) {
				if ((other.isZombie() && includeZombies) || (!other.isZombie() && includeNonzombies)) {
					double dist = distanceEdgeToEdge(other);
					if (dist < closestDist) {
						closest = other;
						closestDist = dist;
					}
				}
			}
		}
		return closest;
	}

	public Nonzombie findClosestNonzombie(Entity[] entities) {
		Entity e = findClosest(entities, false, true);
		return (Nonzombie) e;
	}

	public Zombie findClosestZombie(Entity[] entities) {
		Entity e = findClosest(entities, true, false);
		if (e == null) {
			return null;
		}
		return (Zombie) e;
	}

	public Entity findClosestEntity(Entity[] entities) {
		return findClosest(entities, true, true);
	}

	public void checkBounds() {
		if (this.x < 0) {
			this.x = 0;
		} else if (this.x > 1) {
			this.x = 1;
		}
		if (this.y < 0) {
			this.y = 0;
		} else if (this.y > 1) {
			this.y = 1;
		}
	}

	public void draw() {
		StdDraw.setPenColor(Color.PINK);
		StdDraw.filledCircle(x, y, radius);
	}

	public Entity update(Entity[] entities) {
		return this;
	}

}
