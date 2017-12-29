package words.display;

import javax.swing.JPanel;

public class BoardDisplay extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private char[][] board;
	
	public BoardDisplay(char[][] board) {
		this.board = board;
	}
}
