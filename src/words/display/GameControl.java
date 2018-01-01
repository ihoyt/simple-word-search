package words.display;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameControl {
	private char[][] board;
	private int[][] wordsPos;
	private BoardDisplay boardDisp;
	private WordListDisplay wordList;
	
	private int[] firstSelection;
	private int wordSelected = -1;
	
	private int wordsFound = 0;
	
	public GameControl(char[][] board, int[][]wordsPos, BoardDisplay bd, WordListDisplay words) {
		this.board = board;
		this.wordsPos = wordsPos;
		boardDisp = bd;
		wordList = words;
		firstSelection = new int[2];
		addDispMouseListeners();
	}
	
	private void addDispMouseListeners() {
		boardDisp.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int xCoord = (int) e.getX() / boardDisp.getLetterPanelWidth();
				int yCoord = (int) e.getY() / boardDisp.getLetterPanelHeight();
				
				firstSelection[0] = xCoord;
				firstSelection[1] = yCoord;
				boardDisp.addSelectionLine(xCoord, yCoord);
				boardDisp.repaint();
				
				for(int i = 0; i < wordsPos.length; i++) {
					if(firstSelection[0] == wordsPos[i][0] && firstSelection[1] == wordsPos[i][1]) {
						wordSelected = i;
						i = wordsPos.length;
					}
				}
			}
			
			public void mouseReleased(MouseEvent e) {
				int xCoord = (int) e.getX() / boardDisp.getLetterPanelWidth();
				int yCoord = (int) e.getY() / boardDisp.getLetterPanelHeight();
				
				if (wordSelected != -1 && xCoord == wordsPos[wordSelected][2] && yCoord == wordsPos[wordSelected][3]) {
					boardDisp.addLine(firstSelection[0], firstSelection[1], xCoord, yCoord);
					wordList.crossOffWord(wordSelected);
					wordsFound++;
					checkWin();
				}
				
				wordSelected = -1;
				firstSelection = new int[2];
				boardDisp.removeSelectionLine();
				boardDisp.repaint();
			}
		});
	}
	
	private void checkWin() {
		if(wordsFound == wordsPos.length) {
			boardDisp.win();
		}
	}
}
