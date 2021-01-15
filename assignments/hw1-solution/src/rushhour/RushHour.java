package rushhour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RushHour
{
	public final static int UP = 0;
	public final static int DOWN = 1;
	public final static int LEFT = 2;
	public final static int RIGHT = 3;

	public final static int SIZE = 6;

	char[][] board = new char[6][6];
	
	/**
	 * @param fileName
	 * Reads a board from file and creates the board
	 * @throws Exception if the file not found or the board is bad
	 */
	public RushHour(String fileName) throws Exception {
		File file = new File(fileName);
		if(!file.exists()) {
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
	
	/**
	 * @param carName
	 * @param dir
	 * @param length
	 * Moves car with the given name for length steps in the given direction  
	 * @throws IllegalMoveException if the move is illegal
	 */
	public void makeMove(char carName, int dir, int length) throws IllegalMoveException {
		// TODO implement me
	}
	
	/**
	 * @return true if and only if the board is solved,
	 * i.e., the XX car is touching the right edge of the board
	 */
	public boolean isSolved() {
		// TODO implement me
		return false;
	}
	
}
