import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface WordFrequencyAnalyzer {
	int calculateHighestFrequency(String text);
	int calculateFrequencyForWord (String text, String word);
	List<List<Object>> calculateMostFrequentNWords (String text, int n);
}

class analyzer implements WordFrequencyAnalyzer{//returns the frequency of the most occuring word
	public int calculateHighestFrequency(String text){
		int most = 0;
		Reader wordslist = new Reader();
		List<String> alleWoorden = wordslist.getWords(text);//makes an array of the words
		for (String word : alleWoorden){
			int appearances = Collections.frequency(alleWoorden, word);
			if (appearances > most){most = appearances;}//if a certain word is found more than previous most, its freq is the new most
		}
		return most;
	}

	public int calculateFrequencyForWord (String text, String word){
		int amount = 0;
		Reader wordslist = new Reader();
		List<String> alleWoorden = wordslist.getWords(text);
		return Collections.frequency(alleWoorden, word);//standard java function
	}

	public List<List<Object>> calculateMostFrequentNWords (String text, int n){
		Reader wordslist = new Reader();
		List<String> alleWoorden = wordslist.getWords(text);//list with all words, nonunique
		List<List<Object>> eindResultaat = new ArrayList<>();
		for (int i = 1; i <= n; i++){
			List<Object> nWord = new ArrayList<>();//list containing the nth most frequent word
			List<String> multipleWords = new ArrayList<>();//temporary list for multiple words with the same freq
			int most = 0;
			for (String word : alleWoorden){
				int appearances = Collections.frequency(alleWoorden, word);
				if (appearances > most){//if this word appeared more than the previous record holder
					most = appearances; //its frequency is the new max
					multipleWords.clear();//reset the list to be filled with the new most frequent word
					multipleWords.add(word);
				}
				else if (appearances == most){//another word appears the same amount of times as the most frequent one
					if (! multipleWords.contains(word)){multipleWords.add(word);}//if its a new word, add it
				}
			}
			Collections.sort(multipleWords);//alphabetically
			String mostAlpha = multipleWords.get(0);//first by alphabet
			nWord.add(mostAlpha);//add nth most frequent word
			nWord.add(most);//and how often it appears. this is cleared in the next loop
			eindResultaat.add(nWord);
			alleWoorden.removeAll(Collections.singleton(mostAlpha));//the most frequent word is found, 
			//and should not be considered when finding the next most frequent word
		}
		return eindResultaat;
	}
}