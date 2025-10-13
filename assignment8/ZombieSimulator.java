package assignment8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.NotYetImplementedException;
import support.cse131.Timing;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ZombieSimulator {
	private static final String ZOMBIE_TOKEN_VALUE = "Zombie";
	private Entity[] entities;

	public ZombieSimulator(int n) {
		this.entities = new Entity[n];
	}

	public Entity[] getEntities() {
		return this.entities;
	}

	public void readEntities(Scanner in) {
		for (int i = 0; i < entities.length; i++) {	
			String type = in.next();
			double x = in.nextDouble();
			double y = in.nextDouble();
			if (type.equals(ZOMBIE_TOKEN_VALUE)) {
				entities[i] = new Zombie(x, y);
			} else {
				entities[i] = new Nonzombie(x, y);
			}
		}
	}

	public int getZombieCount() {
		int count = 0;
		for (Entity entity : entities) {
			if (entity != null && entity.isZombie() && entity.isAlive()) {
				count++;
			}
		}
		return count;
	}

	public int getNonzombieCount() {
		int count = 0;
		for (Entity entity : entities) {
			if (entity != null && !entity.isZombie() && entity.isAlive()) {
				count++;
			}
		}
		return count;
	}

	public void draw() {
		StdDraw.clear();
		for (Entity entity : getEntities()) {
			if (entity != null && entity.isAlive()) {
				entity.draw();
				//System.out.println("DRAW : " + entity.getY() + " " + entity.getX());
			}
		}
		int zombieCount = getZombieCount();
		int nonzombieCount = getNonzombieCount();
		StdDraw.setPenColor(StdDraw.BLACK); 
		StdDraw.textLeft(0.01, 0.98, "Zombies: " + zombieCount + " | Nonzombies: " + nonzombieCount);

		StdDraw.show();
	}
// draw, update, read
	public void update() {
		for (int i = 0; i < entities.length; i++) {
			entities[i] = entities[i].update(entities);
		}
	}
//		Entity[] updatedEntities = new Entity[entities.length];
//		for (int i = 0; i < entities.length; i++) {
//			if (entities[i] != null && entities[i].isAlive()) {
//				updatedEntities[i] = entities[i].update(entities); 
//			}
//		this.entities = updatedEntities;
//		}
//	}


	public static void main(String[] args) throws FileNotFoundException {
		StdDraw.enableDoubleBuffering(); 

		JFileChooser chooser = new JFileChooser("zombieSims");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); 

		ZombieSimulator zombieSimulator = new ZombieSimulator(in.nextInt());
		zombieSimulator.readEntities(in);

		double prevTime = Timing.getCurrentTimeInSeconds();
		while (zombieSimulator.getNonzombieCount() >= 0) {
			zombieSimulator.update();
			zombieSimulator.draw();
			StdDraw.pause(20);
		}
	}
}
