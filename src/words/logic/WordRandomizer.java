package words.logic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public abstract class WordRandomizer {
	public static final String DICT_PATH = "res/dict.txt";
	
	private static List<String> loadDict() {
		Path path = Paths.get(DICT_PATH);
		
		try {
			List<String> dict = Files.readAllLines(path);
			return dict;
			
		} catch (IOException e) {
			System.out.println("Error opening dictionary file");
			return null;
		}
	}
	
	public static String[] getWords(int numWords) {
		List<String> dict = loadDict();
		String[] words = new String[numWords];
		
		for(int i = 0; i < numWords; i++) {
			Random rnd = new Random();
			words[i] = dict.get(rnd.nextInt(dict.size())).toUpperCase();
			
			//Check to see if word is already in list, decrement i to repeat if it is
			for(int j = 0; j < i; j++) {
				if (words[j] == words[i]) {
					i--;
				}
			}
		}
		
		return words;
	}
	
	public static String getWord() {
		List<String> dict = loadDict();
		Random rnd = new Random();
		return dict.get(rnd.nextInt(dict.size())).toUpperCase();
	}
}
