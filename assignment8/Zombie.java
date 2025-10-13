package assignment8;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.NotYetImplementedException;

public class Zombie extends Entity {
	public static final double ZOMBIE_SPEED = 0.011;
	public static final double MAX_RADIUS = 0.02;
	public static final double GROWTH_RATE = 0.02;

	public Zombie(double x, double y) {
		super(x, y, true, ZOMBIE_SPEED);
		this.setRadius(0.008);
	}

	public void consumeNonzombie() {
		double newRadius = super.getRadius() * (1 + GROWTH_RATE);
		this.setRadius(Math.min(newRadius, MAX_RADIUS));
	}

	public void draw() {
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledCircle(super.getX(), super.getY(), super.getRadius());
	}
	

	@Override
	
	public Entity update(Entity[] entities) { 
		  Nonzombie closestNonzombie = this.findClosestNonzombie(entities); 
		  if (closestNonzombie == null) {  
		   this.checkBounds();
		   return this;
		  }
		  this.moveToward(closestNonzombie); 
		  if (this.isTouching(closestNonzombie)) { 
		   closestNonzombie.wasConsumed(); 
		   this.consumeNonzombie();
		  }
		  this.checkBounds(); 
		  return this; 
		 }
}
