package words.logic;

import java.util.Random;

public class Board {
	public static final int SIZE = 20;
	
	private char[][] board = new char[SIZE][SIZE];
	
	private String[] wordList;
	
	//Tracks where words start and end in the form of (startX, startY, endX, endY)
	private int[][] wordStartEndPos;
	
	public Board(int numWords) {
		wordList = WordRandomizer.getWords(numWords);
		wordStartEndPos = new int[numWords][4];
		makeBoard(wordList);
		//drawBoard(); //For testing
	}

	//For testing purposes, draws board and words to the console
	private void drawBoard() {
		for(int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		for (String word : wordList) {
			System.out.println(word);
		}
	}

	//Places words and fills the rest with random letters using placeWord() and fillBoard()
	private void makeBoard(String[] words) {
		for (int i = 0; i < words.length; i++) {
			placeWord(words[i], i);
		}
		fillBoard();
	}

	//Fills any empty positions with a random letter
	private void fillBoard() {
		Random rnd = new Random();
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if (board[i][j] == 0) {
					board[i][j] = (char)(rnd.nextInt(26) + 'A');
				}
			}
		}
	}

	//Finds valid position and places words
	private void placeWord(String word, int index, int direction) {
		Random rnd = new Random();
		
		//Direction returned as [xDir, yDir]
		int[] moveXY = getDirection(direction);
		
		//Find valid position, with attempts beginning at random starting point
		int x = rnd.nextInt(SIZE);
		int y = rnd.nextInt(SIZE);
		boolean valid = false;
		
		for (int i = y; i < SIZE && !valid; i++) {
			for (int j = x; j < SIZE && !valid; j++) {
				valid = checkValid(j, i, moveXY, word);
				
				if (valid) {
					putWord(j, i, moveXY, word, index);
					wordStartEndPos[index][0] = j;
					wordStartEndPos[index][1] = i;
					
					//Loop back to beginning if end is reached (checks for x and y to catch the unlikely case of both starting at 0)
				} else if ((i == SIZE - 1 && j == SIZE - 1) && (x != 0 && y != 0)) {
					i = -1;
					j = -1;
					
					//End loop if original starting point has been reached
				} else if (i == x - 1 && j == y - 1) {
					i = SIZE;
					j = SIZE;
				}
			}
		}
		
		//Repeat the process with a different attempted direction if the word was not successfully placed
		if (!valid) {
			if (direction < 7) {
				direction++;
			} else {
				direction = 0;
			}
			placeWord(word, direction);
		}
	}

	//Overloaded method originally called to pick random direction
	private void placeWord(String word, int index) {
		Random rnd = new Random();
		int direction = rnd.nextInt(8);
		placeWord(word, index, direction);
	}
	
	//Puts word into board array
	private void putWord(int xPos, int yPos, int[] direction, String word, int index) {
		for(int i = 0; i < word.length(); i++) {
			board[yPos][xPos] = word.charAt(i);
			if (i == word.length() - 1) {
				wordStartEndPos[index][2] = xPos;
				wordStartEndPos[index][3] = yPos;
			} else {
				xPos += direction[0];
				yPos += direction[1];
			}
		}
		
	}

	//Checks to see if word position is valid
	private boolean checkValid(int xPos, int yPos, int[] direction, String word) {
		for (int i = 0; i < word.length(); i++) {
			if (xPos < 0 || xPos > 19 || yPos < 0 || yPos > 19) {
				return false;
			}
			if (board[yPos][xPos] == 0 || board[yPos][xPos] == word.charAt(i)) {
				xPos += direction[0];
				yPos += direction[1];
			} else {
				return false;
			}
		}
		return true;
	}

	//Returns int[] direction in the form of (xDir, yDir)
	private int[] getDirection(int n) {
		int[] ret;
		switch(n) {
			case 0:
				ret = WordDirections.RIGHT;
				break;
			case 1:
				ret = WordDirections.LEFT;
				break;
			case 2:
				ret = WordDirections.UP;
				break;
			case 3:
				ret = WordDirections.DOWN;
				break;
			case 4:
				ret = WordDirections.UP_RIGHT;
				break;
			case 5:
				ret = WordDirections.DOWN_RIGHT;
				break;
			case 6:
				ret = WordDirections.UP_LEFT;
				break;
			case 7:
				ret = WordDirections.DOWN_RIGHT;
				break;
			default:
				ret = null;
				break;
		}
		return ret;
	}

	public char[][] getBoard() {
		return board;
	}

	public String[] getWordList() {
		return wordList;
	}
	
	public int[][] getWordPositions() {
		return wordStartEndPos;
	}
}