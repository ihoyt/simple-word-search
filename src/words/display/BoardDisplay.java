package words.display;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardDisplay extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private char[][] board;
	private JLabel[][] boardDisp;
	
	//Lines to highlight found words, stored as [numLines][4] with each line having {x1, y1, x2, y2}
	private int[][] lines;
	//Current user selection (if they've clicked and not released yet)
	private int[] selectionLine;
	
	private GameControl gc;
	
	//Selection line colors
	private Color[] colors = { Color.RED, Color.GREEN, Color.CYAN, Color.GRAY, Color.YELLOW, Color.MAGENTA };
	
	public BoardDisplay(char[][] board, int numWords) {
		this.board = board;
		this.setLayout(new GridLayout(board[0].length, board.length));
		makeDisplay();
		lines = new int[numWords][4];
		selectionLine = new int[4];
	}
	
	private void makeDisplay() {
		boardDisp = new JLabel[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				boardDisp[i][j] = new JLabel(" " + board[i][j] + " ");
				boardDisp[i][j].setFont(new Font("Helvetica", Font.BOLD, 20));
				boardDisp[i][j].setHorizontalAlignment(JLabel.CENTER);
				boardDisp[i][j].setVisible(true);
				
				this.add(boardDisp[i][j]);
			}
		}
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paint(g);
		
		g2.setStroke(new BasicStroke(15));
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.30f));
		
		//Examples for drawing lines
		
		int x1 = boardDisp[0][0].getX() + (boardDisp[0][0].getWidth()/2);
		int y1 = boardDisp[0][0].getY() + (boardDisp[0][0].getHeight() / 2);
		int x2 = boardDisp[0][6].getX() + (boardDisp[0][6].getWidth()/2);
		int y2 = y1;
		g2.setColor(Color.GREEN);
		g2.drawLine(x1, y1, x2, y2);
		
		x1 = boardDisp[1][0].getX() + (boardDisp[1][0].getWidth()/2);
		y1 = boardDisp[1][0].getY() + (boardDisp[1][0].getHeight() / 2);
		x2 = boardDisp[7][6].getX() + (boardDisp[7][6].getWidth()/2);
		y2 = boardDisp[7][6].getY() + (boardDisp[7][6].getHeight() / 2);;
		g2.setColor(Color.CYAN);
		g2.drawLine(x1, y1, x2, y2);
	}
	
	public void addLine(int x1, int y1, int x2, int y2) {
		//TODO
	}
	
	public void addSelectionLine(int x1, int y1, int x2, int y2) {
		//TODO
	}
	
	public void addGameControl(GameControl gc) {
		this.gc = gc;
	}
	
	public void addMouseListener(MouseAdapter ma) {
		super.addMouseListener(ma);
	}
	
	public void addMouseMotionListener(MouseMotionAdapter ma) {
		super.addMouseMotionListener(ma);
	}
}
