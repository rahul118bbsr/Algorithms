/**
 * 
 */
package algorithms.mishra.dev.rahul.algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.youtube.com/watch?v=xouin83ebxE&list=PLrmLmBdmIlpslxZUHHWmfOzNn6cA7jvyh&index=2
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 07-Jul-2017 9:08:05 PM
 *
 */
public class NQueenProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the board size: ");
		Position[] positions = solveNQueenProblem(scanner.nextInt());
		scanner.close();
		System.out.println("N Queens positions: ");
		Arrays.stream(positions).forEach(p -> System.out.println(p));
	}

	public static Position[] solveNQueenProblem(int boardSize) {
		Position[] positions = new Position[boardSize];
		boolean hasSolution = solveNQueenUtil(boardSize, 0, positions);
		if (hasSolution) {
			return positions;
		} else {
			return new Position[0];
		}
	}

	private static boolean solveNQueenUtil(int boardSize, int row, Position[] positions) {
		if (boardSize == row) {
			return true;
		}
		int col;
		for (col = 0; col < boardSize; col++) {
			boolean foundSafe = true;

			// check if this row and col is not under attack from any previous queen.
			for (int queen = 0; queen < row; queen++) {
				if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col
						|| positions[queen].row + positions[queen].col == row + col) {
					foundSafe = false;
					break;
				}
			}
			if (foundSafe) {
				positions[row] = new Position(row, col);
				if (solveNQueenUtil(boardSize, row + 1, positions)) {
					return true;
				}
			}
		}
		return false;
	}

}

class Position {
	int row;
	int col;

	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString() {
		return "[" + row + ", " + col + "]";
	}

}
