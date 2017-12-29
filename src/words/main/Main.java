package words.main;

public class Main {
	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		new Thread(ws).start();
	}
}
