package assignment5;

import javax.swing.SwingUtilities;

import assignment5.debug.DrawEntities;
import assignment5.debug.DrawEntitiesCase;
import edu.princeton.cs.introcs.StdDraw;
import support.cse131.Crosshairs;
import support.cse131.DialogBoxes;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DrawEntitiesDebugApp {
	private static void drawCrosshairs(double[][] positions) {
		StdDraw.setPenColor(0, 109, 219);
		Crosshairs.drawMultipleCrosshairs(positions, 0.1);
		StdDraw.show();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			for (DrawEntitiesCase drawEntitiesCase : DrawEntities.getCases()) {
				StdDraw.clear();
				drawEntitiesCase.draw();
				drawCrosshairs(drawEntitiesCase.positions());
				DialogBoxes.askUser(drawEntitiesCase.getText());
			}
			System.exit(0);
		});
	}
}
