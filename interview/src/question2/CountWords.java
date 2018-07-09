package question2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class CountWords {
	static String filename;
	static Map<String, Integer> result;

	CountWords() {
		filename = "";
		result = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
	}

	CountWords(String s) {
		filename = s;
		result = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
	}

	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k2).compareTo(map.get(k1));
				if (compare == 0)
					return 1;
				else
					return compare;
			}
		};

		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		System.out.println("sort success");
		return sortedByValues;
	}

	public static Map mergeMaps(Map<String, Integer> tm1, Map<String, Integer> tm2) throws Exception {
		if (null == tm1 || tm1.size() <= 0 || null == tm2 || tm2.size() <= 0) {
			throw new Exception("there is an empty map");
		}
		Map<String, Integer> tm = new TreeMap<String, Integer>();// 返回结果

		for (String key : tm1.keySet()) {
			if (tm2.containsKey(key)) {
				tm.put(key, tm1.get(key) + tm2.get(key));
				tm2.remove(key);
			} else {
				tm.put(key, tm1.get(key));
			}
		}
		if (null != tm2 && tm2.size() > 0) {
			tm.putAll(tm2);
		}
		System.out.println("merge success");
		return tm;
	}

	public static boolean getWordGroupCount() {
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String content = "";
			while ((content = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(content, "!&(){}+-= ':;<> /\",.");
				while (st.hasMoreTokens()) {
					String key = st.nextToken();
					if (result.containsKey(key))
						result.put(key.toLowerCase(), result.get(key) + 1);
					else
						result.put(key.toLowerCase(), 1);
				}
			}
			br.close();
			fr.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("failed to open file:" + filename);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("some expection occured");
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws Exception {

		// read all txt name from a path
		TxtFile tf = new TxtFile("/Users/at/Documents/workspace/interview/schi");
		tf.readDirectory(tf.f);

		// read words and its frequency from first txt
		CountWords tr1 = new CountWords(tf.txtFile.get(0));
		tr1.getWordGroupCount();
		TreeMap<String, Integer> treemap1 = new TreeMap<String, Integer>();
		treemap1 = (TreeMap<String, Integer>) tr1.result;

		TreeMap<String, Integer> res = new TreeMap<String, Integer>();

		// merge the result of first file and others
		for (int i = 1; i < tf.txtFile.size(); i++) {
			CountWords tr2 = new CountWords(tf.txtFile.get(i));
			tr2.getWordGroupCount();
			TreeMap<String, Integer> treemap2 = new TreeMap<String, Integer>();
			treemap2 = (TreeMap<String, Integer>) tr2.result;
			res = (TreeMap<String, Integer>) mergeMaps(treemap1, treemap2);
		}

		// write result
		FileOutputStream fos = new FileOutputStream("/Users/at/Documents/result.txt");
		OutputStreamWriter oos = new OutputStreamWriter(fos, "UTF-8");
		Map<String, Integer> sortedMap = sortByValues(res);

		Set set = sortedMap.entrySet();
		Iterator i = set.iterator();
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			oos.write(me.getKey() + " " + me.getValue() + "\n");
			System.out.println(me.getKey() + " " + me.getValue());
		}
		oos.close();
		fos.close();
	}
}