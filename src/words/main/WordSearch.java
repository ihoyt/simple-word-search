package words.main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import words.display.BoardDisplay;
import words.display.GameControl;
import words.display.WordListDisplay;
import words.logic.Board;

public class WordSearch extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	public static final String NAME = "That Word Find Game";
	public static final int NUM_WORDS = 20;
	
	private BoardDisplay bd;
	private GameControl gc;
	private WordListDisplay wordList;
	
	public WordSearch() {
		super(NAME);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Board board = new Board(NUM_WORDS);
		
		bd = new BoardDisplay(board.getBoard(), board.getWordList().length);
		wordList = new WordListDisplay(board.getWordList());
		gc = new GameControl(board.getBoard(), board.getWordPositions(), bd, wordList);
		
		//this.setCursor(cursor); //TODO
		this.setLayout(new BorderLayout());
		this.getContentPane().add(bd, BorderLayout.CENTER);
		this.getContentPane().add(wordList, BorderLayout.WEST);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	}
	
	@Override
	public void run() {
		boolean running = true;
		while(running) {
			this.setVisible(true);
		}
	}

}
