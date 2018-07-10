package question2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class CountWords {
	
	
	
	public List readFile(String filename){//read one file to a list
		File file = new File(filename);
		
		List<String> data = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "UTF-8"));
			String s= "";
			while ((s = br.readLine()) != null) {
				if ((s != "\r") && (s != "\n") && (s != "\t")) {
					data.add(s);
					System.out.println("read"+s);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			}
		return data;
		
	}
	
	
	
	
	
	public Set<String> countWords(List ls){
		
		 Set<String> uniqueWords = new HashSet<String>(ls);
		 for (String word : uniqueWords) {
		 System.out.println(word + ": " + Collections.frequency(ls, word));
		 }
		 return uniqueWords;
	}
	
	public List<String> readDirectory(String dire){
		List<String> ls = new ArrayList<String>();
		 return ls;
	}

	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

