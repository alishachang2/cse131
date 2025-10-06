package assignment6;

import assignment6.maxpath.gui.MaxPathLengthDebugAppFrame;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class MaxPathLengthDebugApp {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> MaxPathLengthDebugAppFrame.createAndShowGUI());
	}
}
