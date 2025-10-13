package assignment8;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.NotYetImplementedException;

public class Nonzombie extends Entity {
	public static final double NONZOMBIE_SPEED = 0.01;

	public Nonzombie(double x, double y) {
		super(x,y, false, NONZOMBIE_SPEED);
	}
	
	public Zombie convert() {
		return new Zombie (super.getX(),super.getY());
	}
	
	public void draw() {
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.filledCircle(super.getX(), super.getY(),super.getRadius());
	

	}
	
	public Entity update(Entity[] entities) {
		Zombie closestZombie = super.findClosestZombie(entities);
		if (closestZombie != null) {
		moveAwayFrom(closestZombie);
		checkBounds();
		if (isTouching(closestZombie)) {
			if(Math.random()<0.8) {
				return this.convert();
			} else { 
				wasConsumed();
				closestZombie.consumeNonzombie();
			}
		}
	}
		return this;
	}

}


