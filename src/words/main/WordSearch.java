package words.main;

import javax.swing.JFrame;

import words.display.BoardDisplay;
import words.display.GameControl;
import words.display.WordListDisplay;
import words.logic.Board;

public class WordSearch extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	public static final String NAME = "That Word Find Game";
	
	private BoardDisplay bd;
	private GameControl gc;
	private WordListDisplay wordList;
	
	public WordSearch() {
		super("NAME");
		Board board = new Board(2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bd = new BoardDisplay(board.getBoard());
		wordList = new WordListDisplay(board.getWordList());
		gc = new GameControl(board.getBoard(), board.getWordPositions(), bd, wordList);
	}
	
	@Override
	public void run() {
		
	}

}
