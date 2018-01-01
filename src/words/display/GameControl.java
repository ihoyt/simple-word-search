package words.display;

import java.awt.Event;

public class GameControl {
	private char[][] board;
	private int[][] wordsPos;
	private BoardDisplay boardDisp;
	private WordListDisplay wordList;
	
	public GameControl(char[][] board, int[][]wordsPos, BoardDisplay bd, WordListDisplay words) {
		this.board = board;
		this.wordsPos = wordsPos;
		boardDisp = bd;
		wordList = words;
	}
	
	public void notify(Event e) {
		//TODO
	}
}
