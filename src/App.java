import java.util.List;

public class App {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println("Hello World, Java app"); 
        readFile read = new readFile();
		//heleTekst();
		String text = read.text2String("hamlet.txt");
		//System.out.println(text);
		Reader wordslist = new Reader();
		analyzer Analyzer = new analyzer();
		List<String> alleWoorden = wordslist.getWords(text);
		System.out.println("totaal "+ alleWoorden.size() + " woorden.");
		int freq = wordslist.getFrequency("a", alleWoorden);
		System.out.println(freq);
		int most = Analyzer.calculateHighestFrequency(text);
		System.out.println(most);
		int amountThe = Analyzer.calculateFrequencyForWord(text, "sex");
		System.out.println("frequency of the word 'sex': " + amountThe);
		List<List<Object>> nMost = Analyzer.calculateMostFrequentNWords(text, 7);
		System.out.println("7 most frequent words: " + nMost);

		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("computation completed in " + totalTime*1E-9 + " s.");

	} 
}
