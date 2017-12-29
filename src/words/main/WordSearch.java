package words.main;

import java.awt.Canvas;

import words.logic.Board;

public class WordSearch extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String NAME = "That Word Find Game";
	
	public WordSearch() {
		Board board = new Board(2);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
