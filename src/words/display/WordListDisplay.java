package words.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WordListDisplay extends JPanel {

	private static final long serialVersionUID = 1L;
	private String[] words;
	private JLabel[] wordsDisp;
	
	public WordListDisplay(String[]words) {
		this.words = words;
		wordsDisp = new JLabel[words.length];
		super.setLayout(new GridLayout(words.length, 1));
		addWords();
		setBackground(new Color(150, 214, 253));
		setPreferredSize(new Dimension(150, 400));
		setAlignmentX(JPanel.CENTER_ALIGNMENT);
	}
	
	private void addWords() {
		for (int i = 0; i < words.length; i++) {
			wordsDisp[i] = new JLabel(words[i]);
			wordsDisp[i].setForeground(Color.BLACK);
			wordsDisp[i].setFont(new Font("Helvetica", Font.BOLD, 20));
			wordsDisp[i].setVisible(true);
			wordsDisp[i].setHorizontalAlignment(JLabel.CENTER);
			this.add(wordsDisp[i]);
		}
	}
	
	public void crossOffWord(int index) {
		wordsDisp[index].setForeground(Color.GRAY);
	}
	
}
