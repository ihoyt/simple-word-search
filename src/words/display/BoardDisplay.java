package words.display;

import java.awt.Font;
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
		for(char[] i : board) {
			for(char j : i) {
				JLabel lbl = new JLabel(" " + j + " ");
				lbl.setFont(new Font("Helvetica", Font.BOLD, 20));
				lbl.setVisible(true);
				this.add(lbl);
			}
		}
	}
}
