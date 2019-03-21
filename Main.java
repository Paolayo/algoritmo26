package algoritmo26;

import org.apache.commons.lang3.ArrayUtils;

public class Main {

	private static int solutionNumber = 0;
	private static int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

	public static void main(String[] args) {

		assignNumbers(values, new int[12], 0);

	}

	private static boolean isSolution(int[] solution) {
		int a = solution[0] + solution[2] + solution[5] + solution[7];
		int b = solution[0] + solution[3] + solution[6] + solution[10];
		int c = solution[11] + solution[8] + solution[5] + solution[1];
		int d = solution[11] + solution[9] + solution[6] + solution[4];
		int e = solution[1] + solution[2] + solution[3] + solution[4];
		int f = solution[7] + solution[8] + solution[9] + solution[10];
		int g = solution[2] + solution[3] + solution[5] + solution[6] + solution[8] + solution[9];

		if (a == b && a == c && a == d && a == e && a == f && a == g) {
			printSolution(solution);
			return true;
		}
		return false;
	}

	private static void printSolution(int[] solution) {

		System.out.print("Solución!! " + solutionNumber + " ");

		for (int value : solution) {
			System.out.print(value + ", ");
		}

		System.out.println();
	}

	private static void assignNumbers(int[] values, int[] solution, int position) {

		for (int value : values) {
			solution[position] = value;
			if (position == 11) {
				solutionNumber++;
				isSolution(solution);
			} else {
				assignNumbers(ArrayUtils.removeElement(values, value), solution, 1 + position);
			}
		}

	}

}
