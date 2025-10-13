package assignment8;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import assignment8.debug.DrawEntities;
import assignment8.debug.DrawEntitiesCase;
import edu.princeton.cs.introcs.StdDraw;
import support.cse131.DialogBoxes;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DrawEntitiesDebugApp {
	public static void drawCrosshairs(double x, double y, double halfLength) {
		StdDraw.line(x, y - halfLength, x, y + halfLength);
		StdDraw.line(x - halfLength, y, x + halfLength, y);
	}
 
	private static void drawBoundingCirclesAndCrosshairs(Entity[] entities) {
		StdDraw.setPenColor(0, 109, 219);
		for (Entity entity : entities) {
			StdDraw.circle(entity.getX(), entity.getY(), entity.getRadius());
			drawCrosshairs(entity.getX(), entity.getY(), entity.getRadius() * 2);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Object[] options = { "Continue", "Exit" };
			for (DrawEntitiesCase drawEntitiesCase : DrawEntities.getCases()) {
				StdDraw.clear();
				Entity[] entities = drawEntitiesCase.getEntities();
				for (Entity entity : entities) {
					entity.draw();
				}
				drawBoundingCirclesAndCrosshairs(entities);
				StdDraw.show();
				if (!DialogBoxes.askUser(drawEntitiesCase.getText(), "via class Entity draw()",
						JOptionPane.QUESTION_MESSAGE, options)) {
					System.exit(0);
				}
			}
			if (DialogBoxes.askUser("Continue to ZombieSimulator?", "", JOptionPane.QUESTION_MESSAGE, options)) {
				for (DrawEntitiesCase drawEntitiesCase : DrawEntities.getCases()) {
					StdDraw.clear();
					ZombieSimulator zombieSimulator = drawEntitiesCase.createZombieSimulator();
					zombieSimulator.draw();
					drawBoundingCirclesAndCrosshairs(zombieSimulator.getEntities());
					StdDraw.show();
					if (!DialogBoxes.askUser(drawEntitiesCase.getText(), "via class ZombieSimulator draw()",
							JOptionPane.QUESTION_MESSAGE, options)) {
						break;
					}
				}
			}
			System.exit(0);
		});
	}
}
