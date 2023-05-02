
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class readFile {
	public String heleTekst(String fullText) {
		return fullText;
	}

	public String text2String(String fileName) {
	    try {
	    	String fullText = new String();
	    	File myObj = new File(fileName);
	    	Scanner myReader = new Scanner(myObj);
	    	while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        //System.out.println(data);
				fullText = fullText.concat(" ");
		        fullText = fullText.concat(data);
		        //heleTekst(fullText);
	    		}
		    myReader.close();
		    return fullText;
	    }
	    catch (FileNotFoundException e) {
	    	System.out.println("An error occurred.");
	    	e.printStackTrace();
	    	return "oeps";
	    }
	}
	
}
