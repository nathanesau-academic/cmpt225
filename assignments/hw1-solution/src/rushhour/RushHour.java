package rushhour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class RushHour {
	public final static int UP = 0;
	public final static int DOWN = 1;
	public final static int LEFT = 2;
	public final static int RIGHT = 3;

	public final static int SIZE = 6;

	char[][] board = new char[6][6];

	/**
	 * @param fileName Reads a board from file and creates the board
	 * @throws Exception if the file not found or the board is bad
	 */
	public RushHour(String fileName) throws Exception {
		File file = new File(fileName);
		if (!file.exists()) {
			throw new FileNotFoundException("File " + fileName + " not found");
		}

		Scanner scanner = new Scanner(file);
		int lineNum = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			for (int i = 0; i < 6; i++) {
				board[lineNum][i] = line.charAt(i);
			}
			lineNum += 1;
		}
		scanner.close();
	}

	private List<Integer[]> getCarSquares(char carName) {
		List<Integer[]> carSquares = new ArrayList<Integer[]>();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (board[i][j] == carName) {
					carSquares.add(new Integer[] { i, j });
				}
			}
		}
		return carSquares;
	}

	private boolean isDirValid(List<Integer[]> carSquares, int dir) {
		// determine which way the car is facing (either HORIZONTAL or VERTICAL)
		Integer[] firstCarSquare = carSquares.get(0);
		for (int i = 1; i < carSquares.size(); i++) {
			Integer[] square = carSquares.get(i);
			if (square[1] != firstCarSquare[1]) {
				// columns are varying - this means the car is facing HORIZONTAL
				return dir == LEFT || dir == RIGHT;
			}
		}

		// columns are not varying - this means rows are varying
		return dir == UP || dir == DOWN;
	}

	private Integer[] getShiftedSquare(Integer[] square, int dir, int length) throws IllegalMoveException {
		if (dir == LEFT) {
			return new Integer[] { square[0], square[1] - length };
		} else if (dir == RIGHT) {
			return new Integer[] { square[0], square[1] + length };
		} else if (dir == UP) {
			return new Integer[] { square[0] - length, square[1] };
		} else if (dir == DOWN) {
			return new Integer[] { square[0] + length, square[1] };
		}

		throw new IllegalMoveException("Unkown direction passed to makeMove");
	}

	private List<Integer[]> getShiftedSquares(List<Integer[]> carSquares, int dir, int length)
		throws IllegalMoveException
	{
		List<Integer[]> shiftedCarSquares = new ArrayList<Integer[]>();
		for (Integer[] carSquare : carSquares) {
			shiftedCarSquares.add(getShiftedSquare(carSquare, dir, length));
		}
		return shiftedCarSquares;
	}

	/**
	 * @param carName
	 * @param dir
	 * @param length  Moves car with the given name for length steps in the given
	 *                direction
	 * @throws IllegalMoveException if the move is illegal
	 */
	public void makeMove(char carName, int dir, int length) throws IllegalMoveException {

		List<Integer[]> carSquares = getCarSquares(carName);
		if (!isDirValid(carSquares, dir)) {
			throw new IllegalMoveException("Invalid direction passed to makeMove");
		}

		// outer square of car (first element if left or up, last element otherwise)
		Integer[] outerSquare = (dir == LEFT || dir == UP) ? carSquares.get(0) : carSquares.get(carSquares.size() - 1);
		for (int i = 1; i < length + 1; i++) {
			// outer square of car after move
			Integer[] shiftedOuterSquare = getShiftedSquare(outerSquare, dir, i);

			// check if boundary check satisfied
			if (shiftedOuterSquare[0] < 0 || shiftedOuterSquare[0] >= 6 || shiftedOuterSquare[1] < 0
					|| shiftedOuterSquare[1] >= 6) {
				throw new IllegalMoveException("Move outside of grid is not allowed");
			}

			// check for collision
			if (board[shiftedOuterSquare[0]][shiftedOuterSquare[1]] != '.') {
				throw new IllegalMoveException("Moving into another car is not allowed");
			}
		}

		List<Integer[]> shiftedCarSquares = getShiftedSquares(carSquares, dir, length);

		// clear carSquares
		for (Integer[] square : carSquares) {
			board[square[0]][square[1]] = '.';
		}

		// write shiftedCarSquares
		for (Integer[] square : shiftedCarSquares) {
			board[square[0]][square[1]] = carName;
		}
	}

	/**
	 * @return true if and only if the board is solved, i.e., the XX car is touching
	 *         the right edge of the board
	 */
	public boolean isSolved() {
		for (int i = 0; i < 6; i++) {
			if (board[i][5] == 'X') {
				// found XX car at right edge
				return true;
			}
		}

		return false;
	}

}
