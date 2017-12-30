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
		super(NAME);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Board board = new Board(5);
		//System.out.println("Here");
		bd = new BoardDisplay(board.getBoard());
		wordList = new WordListDisplay(board.getWordList());
		gc = new GameControl(board.getBoard(), board.getWordPositions(), bd, wordList);
		
		this.getContentPane().add(bd);
		this.getContentPane().add(wordList);
		this.pack();
		
	}
	
	@Override
	public void run() {
		boolean running = true;
		while(running) {
			this.setVisible(true);
		}
	}

}
