package question2;

import java.io.*;
import java.util.*;

/**
 * this question is really hard, so I just build the frame.
 * 
 *
 */
public class count {

	// read all txt file from a directory into a list
	public static List<String> readDirectory(String name) {
		List<String> ls = new ArrayList<String>();
		return ls;
	}

	// read file's word into a list
	public static List readFile(String filename) {// read one file to a list
		File file = new File(filename);

		List<String> data = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String s = "";
			while ((s = br.readLine()) != null) {
				if ((s != "\r") && (s != "\n") && (s != "\t")) {
					data.add(s);
					System.out.println("read" + s);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}

	// write result to a file
	public static boolean writeFile(String filename, Map<String, Integer> tm) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");
			Integer integ = null;
			Iterator iter = tm.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				// get key
				String key = (String) entry.getKey();
				// get value
				integ = (Integer) entry.getValue();
				oos.write(integ + "/t" + key);
			}
			oos.close();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// count word's frequency and ignore the case
	public static Map countWord(List<String> ls) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < ls.size(); i++) {
			Integer count = map.get(ls.get(i));
			if (count == null) {
				map.put(ls.get(i), 1);
			} else {
				map.put(ls.get(i), ++count);
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + entry.getValue());
		}
		return map;

	}
	
	/*public boolean equalIgnore(String s1, String s2) {
		return s1 == null ? s2 == null : s1.equalsIgnoreCase(s2);

	}*/

	// sort result by word's frequency and alphabe
	public boolean sort(Map mp) {
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> filename = new ArrayList<String>();
		filename = readDirectory("directory's name");// read all txt file's
														// names into
		// a list

		List<String> list = new ArrayList<String>();// all words
		for (int i = 0; i < filename.size(); i++) {
			String s = filename.get(i);
			List<String> tempet = new ArrayList<String>();//
			tempet = readFile(s);// read one file's words into a list
			list.addAll(tempet);// add this list to all words
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		map = countWord(list);
		if (writeFile("result.txt", map)) {
			System.out.println("success");
		} else
			System.out.println("wrong");
	}
}
