package words.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

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
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(150, 400));
		setAlignmentX(JPanel.CENTER_ALIGNMENT);
	}
	
	private void addWords() {
		for (int i = 0; i < words.length; i++) {
			wordsDisp[i] = new JLabel(words[i]);
			wordsDisp[i].setVisible(true);
			wordsDisp[i].setHorizontalAlignment(JLabel.CENTER);
			this.add(wordsDisp[i]);
		}
	}
	
	
}
