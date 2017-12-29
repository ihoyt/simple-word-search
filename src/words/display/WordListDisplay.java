package words.display;

import javax.swing.JPanel;

public class WordListDisplay extends JPanel {

	private static final long serialVersionUID = 1L;
	private String[] words;
	
	public WordListDisplay(String[]words) {
		this.words = words;
	}
}
