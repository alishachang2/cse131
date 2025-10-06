package assignment6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	public static double exponent(int base, int exp) {
		if (exp == 0) {
			return 1;
		} else if (exp < 0) {
			return 1.0 / exponent(base, -exp);
		} else {
			return base * exponent(base, exp - 1);
		}
	}

	public static int arraySum(int[] array) {
		return arraySumHelper(array, 0);

	}

	public static int arraySumHelper(int[] array, int index) {
		if (index < array.length) {
			return array[index] + arraySumHelper(array, index + 1);
		} else {
			return 0;
		}
	}
	// trace {1,4,5} array.length=3
	// arraySumHelper(array, 0) = 1 + arraySumHelper (array,1)
	// arraySumHelper(array, 1) = 5 + arraySumHelper (array, 2)
	// arraySumHelper(array, 2) = 10 + arraySumHelper (array, 3)
	// arraySumHelper (array, 3) = 0
	// sum causes issues because it resents the value
	// new base case

	public static String dragon(int n) {
		if (n == 0) {
			return "F-H";
		}
		if (n > 0) {
			return (dragon(n - 1)).replace("F", "F-X").replace("H", "F+H").replace("X", "H");
		}
		return "";
	}

	public static int maxPathLength(boolean[][] chart, int r, int c) {
		if (r < 0 || r >= chart.length || c < 0 || c >= chart[0].length || !chart[r][c]) {
			return 0;
		}
		
		chart[r][c] = false;
		int up = maxPathLength(chart, r - 1, c);
		int down = maxPathLength(chart, r + 1, c);
		int left = maxPathLength(chart, r, c - 1);
		int right = maxPathLength(chart, r, c + 1);
		chart[r][c] = true;
		
		int maxUpDown = Math.max(up, down);
		int maxLeftRight = Math.max(left, right);
		return 1 + Math.max(maxUpDown, maxLeftRight);
	}
}
