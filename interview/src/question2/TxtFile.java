package question2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//read all txt files into a list
public class TxtFile {
	String basePath;
	static ArrayList<String> txtFile;
	File f;

	TxtFile() {
	}

	TxtFile(String s) {
		basePath = s;
		txtFile = new ArrayList<String>();
		f = new File(s);
		;
	}

	public static void readDirectory(File f) throws IOException {

		File[] listOfFiles = f.listFiles();
		for (File temp : listOfFiles) {
			if (!temp.isFile()) {
				readDirectory(temp);
			}
			if (temp.isFile() && temp.getAbsolutePath().endsWith(".txt")) {
				String txt = temp.getName();
				txtFile.add(temp.getAbsolutePath());
				System.out.println(temp.isFile() + "  " + temp.getAbsolutePath());
			}
		}
	}
}
