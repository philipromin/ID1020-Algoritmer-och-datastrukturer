import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class labb6 {
	
    public static void wordLocation(String text, String word) {
        String[] words = text.split(" ");

        // Stores the number of spaces from start of string until "word"
        ArrayList<Integer> spacesBefore = new ArrayList<Integer>();
        for (int i = 0; i < words.length; i++) {
        	if (words[i].equals(word)) {
        		spacesBefore.add(i);
        	}
        }

        // Stores the text as a char array
        char[] chars = text.toCharArray();
        ArrayList<Integer> wordLocation = new ArrayList<>();
        for (int i = 0; i < spacesBefore.size(); i++) {
        	for (int j = 0; i < chars.length; j++) {
        		if (chars[j] == ' ') {
        			spacesBefore.set(i, spacesBefore.get(i) - 1);
        		}
        		if (spacesBefore.get(i) == 0) {
        			wordLocation.add(j+2);
        			break;
        		}
        	}
        }
        for (Integer i : wordLocation) {
        	System.out.println("'" + word + "' was found at position " + i);
  	    }
    }
    
	public static void main(String[] args) throws FileNotFoundException {
		
    	Scanner scanner = new Scanner(new FileReader("C:\\Users\\phili\\Documents\\Skola\\Algoritmer\\Labb3\\text.txt"));
    	String content = scanner.useDelimiter("\\A").next();
    	scanner.close();
    	
	    //String testText = "Find the word at the specific location"; // "the" Should be 6 and 18
	    
	    wordLocation(content, "the"); 
	}
}