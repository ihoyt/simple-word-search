package words.display;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardDisplay extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private char[][] board;
	private JLabel[][] boardDisp;
	
	public BoardDisplay(char[][] board) {
		this.board = board;
		this.setLayout(new GridLayout(board[0].length, board.length));
		makeDisplay();
		System.out.println("Here");
	}
	
	private void makeDisplay() {
		int x = 0;
		int y = 0;
		
		for(char[] i : board) {
			for(char j : i) {
				JLabel lbl = new JLabel(j + "");
				this.add(lbl);
			}
		}
	}
}
