package assignment6;

import java.util.Objects;
import java.util.Optional;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import assignment6.dragon.Dragons;
import support.cse131.DialogBoxes;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DragonDebugApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {

			int i = 0;
			while (true) {
				String actual = RecursiveMethods.dragon(i);
				Dragons.drawDragon(actual);

				Optional<String> expectedOpt = Dragons.getExpected(i);

				boolean isKnown = expectedOpt.isPresent();
				boolean isCorrect = isKnown && Objects.equals(actual, expectedOpt.get());
				boolean isKnownToBeIncorrect = isKnown && !isCorrect;

				StringBuilder sbTitle = new StringBuilder();
				sbTitle.append("Current: dragon(").append(i).append(") ");
				if (isKnown) {
					if (isCorrect) {
						sbTitle.append("correct");
					} else {
						sbTitle.append("INCORRECT (expected image below)");
					}
				} else {
					sbTitle.append("unknown");
				}

				Optional<Icon> expectedIcon = Dragons.getExpectedIcon(i);
				String text = String.format("Continue to dragon(%d)?", i + 1);
				JLabel message = new JLabel(text);
				if (isKnownToBeIncorrect) {
					if (expectedIcon.isPresent()) {
						message.setIcon(expectedIcon.get());
					}
				}
				int messageType = isKnownToBeIncorrect ? JOptionPane.ERROR_MESSAGE : JOptionPane.QUESTION_MESSAGE;
				Object[] options = { "Continue", "Exit" };
				if (DialogBoxes.askUser(message, sbTitle.toString(), messageType, options)) {
					// pass
				} else {
					System.exit(0);
					// break;
				}
				++i;
			}
		});
	}
}
