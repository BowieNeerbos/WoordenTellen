
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
//import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController


public interface WordFrequency {
	List getWords(String text);
	int getFrequency(String woord, List<String> wordsList);// String word; int count; 
	//int Ascii(char letter);
}

class Reader implements WordFrequency {
	public List getWords(String text) {//makes a list with all words in a text, including multiple entries
		List woorden = new ArrayList();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<=text.length()-1; i++){
			char currChar = text.charAt(i);
			if (((int) currChar < 89 && (int) currChar > 64) || ((int) currChar < 123 && (int) currChar > 96)){
				sb.append(currChar);
			}
			else {
				if (sb.length() != 0){
					woorden.add(sb.toString().toLowerCase());
					sb.setLength(0);
				}
			}
		}
		return woorden;
	}
	public int getFrequency(String woord, List<String> wordsList) {
		int freq = 0;
		woord = woord.toLowerCase();
		for (String ditWoord : wordsList){
			if (woord.equals(ditWoord)){
				freq++;
			}
		}
		return freq;
	}
	public int Ascii(char letter) {
		int ascii = letter;
		return ascii;
	}
	public int Letter(int ascii) {
		char letter = (char) ascii;
		return letter;
	}
}

