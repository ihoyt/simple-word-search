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
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardDisplay extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private char[][] board;
	private JLabel[][] boardDisp;
	
	//Lines to highlight found words, stored as [numLines][4] with each line having {x1, y1, x2, y2} referencing letter array coords (not absolute coords)
	private int[][] lines;
	private int linesIndex = 0;
	
	//Current user selection (if they've clicked and not released yet) {x1, y1, absolute x2, absolute y2} <- cause x2, y2 is on the mouse
	private int[] selectionLine;
	private boolean hasClicked = false;

	//Selection line colors
	private Color[] colors = { Color.RED, Color.GREEN, Color.CYAN, Color.BLUE, new Color(200, 65, 10), Color.MAGENTA };
	
	public BoardDisplay(char[][] board, int numWords) {
		this.board = board;
		this.setLayout(new GridLayout(board[0].length, board.length));
		makeDisplay();
		lines = new int[numWords][4];
		selectionLine = new int[4];
		
		//For color testing
		/*addLine(1, 3, 7, 3);
		addLine(5, 7, 10, 12);
		addLine(3, 10, 7, 10);
		addLine(10,10,19,19);
		addLine(0, 19, 0, 14);
		addLine(19, 0, 19, 5);*/
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
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
					selectionLine[2] = e.getX();
					selectionLine[3] = e.getY();
					repaint();
			}
		});
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		super.paint(g);
		
		int colorIndex = 0;
		g2.setStroke(new BasicStroke(15));
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.40f));
		
		for(int[] line : lines) {
			if (line[0] != line[2] || line[1] != line[3]) {
				int x1 = boardDisp[line[1]][line[0]].getX() + (boardDisp[line[1]][line[0]].getWidth()/2);
				int y1 = boardDisp[line[1]][line[0]].getY() + (boardDisp[line[1]][line[0]].getHeight()/2);
				int x2 = boardDisp[line[3]][line[2]].getX() + (boardDisp[line[3]][line[2]].getWidth()/2);
				int y2 = boardDisp[line[3]][line[2]].getY() + (boardDisp[line[3]][line[2]].getHeight()/2);
				
				g2.setColor(colors[colorIndex++ % colors.length]);
				g2.drawLine(x1, y1, x2, y2);
			}
		}
		//Draw selection line if user hasClicked
		if (hasClicked) {
			int x1 = boardDisp[selectionLine[1]][selectionLine[0]].getX() + (boardDisp[selectionLine[1]][selectionLine[0]].getWidth()/2);
			int y1 = boardDisp[selectionLine[1]][selectionLine[0]].getY() + (boardDisp[selectionLine[1]][selectionLine[0]].getHeight()/2);
			int x2 = selectionLine[2];
			int y2 = selectionLine[3];
			if (x2 != 0 || y2 != 0) {
				g2.setColor(Color.GRAY);
				g2.drawLine(x1, y1, x2, y2);
			}
		}
	}
	
	public void addLine(int x1, int y1, int x2, int y2) {
		lines[linesIndex][0] = x1;
		lines[linesIndex][1] = y1;
		lines[linesIndex][2] = x2;
		lines[linesIndex][3] = y2;
		linesIndex++;
	}
	
	public void addSelectionLine(int x1, int y1) {
		selectionLine[0] = x1; 
		selectionLine[1] = y1;
		hasClicked = true;
	}
	
	public void removeSelectionLine() {
		selectionLine = new int[4];
		hasClicked = false;
	}

	public void addMouseListener(MouseAdapter ma) {
		super.addMouseListener(ma);
	}
	
	public int getLetterPanelWidth() {
		return boardDisp[0][0].getWidth();
	}
	
	public int getLetterPanelHeight() {
		return boardDisp[0][0].getHeight();
	}
	
	public void win() {
		//TODO
	}
}
