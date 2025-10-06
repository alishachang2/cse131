package assignment5;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

import javax.swing.JFileChooser;

import edu.princeton.cs.introcs.StdDraw;

public class ZombieSimulator {
	public static final int X = 0;
	public static final int Y = 1;
	private static final String ZOMBIE_TOKEN_VALUE = "Zombie";

	private static final Color ZOMBIE_COLOR = new Color(146, 0, 0);
	private static final Color NONZOMBIE_COLOR = new Color(0, 0, 0);
	private static final Color TEXT_COLOR = new Color(73, 0, 146);
	public static final double ENTITY_RADIUS = 0.008;

	public static final double RANDOM_DELTA_HALF_RANGE = 0.006;
	
	public static final double TEXT_POSITION_X = 0.1;
	public static final double TEXT_POSITION_Y = 0.95;
	public static final int MIN_XY_BOUND = 0;
	public static final int MAX_XY_BOUND = 1;
	public static final int SIMULATION_STEP_DELAY_MS = 500;

	
	public static void readEntities(Scanner in, boolean[] areZombies, double[][] positions) {
		for (int i = 0; i < areZombies.length; i++) {
			String a = in.next(); 
			if (a.equals("Zombie")) {
				areZombies[i]=true;
				} else {
				areZombies[i]=false;
			}
			positions [i][X]=in.nextDouble();
			positions [i][Y]=in.nextDouble();
		}
	}

	public static void drawEntities(boolean[] areZombies, double[][] positions) {
		StdDraw.clear();
		for (int i = 0; i<areZombies.length; i++) {
			if (areZombies [i]) {
				StdDraw.setPenColor(ZOMBIE_COLOR);
				} else {
					StdDraw.setPenColor(NONZOMBIE_COLOR);
				}
			StdDraw.filledCircle(positions[i][X], positions[i][Y], ENTITY_RADIUS);
		}
		StdDraw.setPenColor(TEXT_COLOR);
		StdDraw.text(TEXT_POSITION_X, TEXT_POSITION_Y, nonzombieCount(areZombies)+ "/" + areZombies.length);
		StdDraw.show();
	}

	public static boolean touchingZombie(int index, boolean[] areZombies, double[][] positions) {
		for (int i = 0; i < areZombies.length; i++) {
			double distance = (Math.pow(positions[i][X] - positions[index][X], 2))
					+ (Math.pow((positions[i][Y] - positions[index][Y]), 2));
			double touchingDistance = Math.pow((2 * ENTITY_RADIUS), 2);
			if ((areZombies[i] && (distance <= touchingDistance))) {
				return true;
			}
		}
		return false;
	}
		
	public static void updateEntities(boolean[] areZombies, double[][] positions) {
		for (int i = 0; i < areZombies.length; i++) {
			boolean newPosition = false;
			double updateX = 0;
			double updateY = 0;
			while (!newPosition) {
				updateX = -RANDOM_DELTA_HALF_RANGE + (RANDOM_DELTA_HALF_RANGE * 2 * Math.random());
				updateY = -RANDOM_DELTA_HALF_RANGE + (RANDOM_DELTA_HALF_RANGE * 2 * Math.random());
				if (positions[i][X] + updateX <= MAX_XY_BOUND && positions[i][X] + updateX >= MIN_XY_BOUND && positions[i][Y] + updateY <= MAX_XY_BOUND
						&& positions[i][Y] + updateY >= MIN_XY_BOUND) {
					positions[i][X] += updateX;
					positions[i][Y] += updateY;
					newPosition = true;
				}
			}
			if (touchingZombie(i,areZombies,positions)) {
				areZombies [i]=true;
			}
		}
	}
	
	public static int nonzombieCount(boolean [] areZombies) {
		int nonZombieCount = 0;
		for (int i = 0; i < areZombies.length; i++) {
			if (!areZombies[i]) {
				nonZombieCount++;
			}
		}
		return nonZombieCount;
	}
	
	private static void runSimulation(Scanner in) {
		StdDraw.enableDoubleBuffering(); 		
		int N = in.nextInt();
		boolean [] areZombies = new boolean[N];
		double[][] positions = new double [N][2];
		readEntities(in, areZombies, positions);
		drawEntities(areZombies, positions);
		StdDraw.pause(SIMULATION_STEP_DELAY_MS);
		while (nonzombieCount(areZombies)!=0) {
			updateEntities(areZombies,positions);
			drawEntities(areZombies, positions);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		JFileChooser chooser = new JFileChooser("zombieSims");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		runSimulation(in);
	}

}
