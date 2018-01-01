package words.display;

import java.awt.Event;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

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
		addDispMouseListeners();
	}
	
	private void addDispMouseListeners() {
		boardDisp.addMouseListener(new MouseAdapter() {
			//TODO
		});
		
		boardDisp.addMouseMotionListener(new MouseMotionAdapter() {
			//TODO
		});
	}
}
