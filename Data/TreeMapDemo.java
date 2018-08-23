package yu;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;



public class TreeMapDemo {
	//static String filename;
	static Map<String, Integer> result;
	
	TreeMapDemo() {
		result = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
	}

	
	public static Map mergeMaps(Map<String, Integer> tm1, Map<String, Integer> tm2) throws Exception{
		if((tm1.isEmpty())&&(tm2.isEmpty())){
			throw new Exception("there is empty map");
		}
		Map<String, Integer> tm = new TreeMap<String, Integer>();//返回结果
		
		for(String key:tm1.keySet()){
			if(tm2.containsKey(key)){
				tm.put(key, tm1.get(key)+tm2.get(key));
			tm2.remove(key);
			}
			else{
				tm.put(key, tm1.get(key));
			}
		}
		if(null!=tm2 && tm2.size()>0){
			tm.putAll(tm2);
		}
		
		return tm;
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
		return sortedByValues;
	}

	public static void getWordGroupCount(String filename) throws Exception{
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String content = "";
			while ((content = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(content, "!&(){}+-= ':;<> /\",.");
				while (st.hasMoreTokens()) {
					String key = st.nextToken();
					if (result.containsKey(key))
						result.put(key, result.get(key) + 1);
					else
						result.put(key, 1);
				}
			}
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("failed to open file:" + filename);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("some expection occured");
			e.printStackTrace();
		}
		
	}

	public static void main(String args[]) throws Exception {
		
		TreeMapDemo tr1=new TreeMapDemo();
		tr1.getWordGroupCount("/Users/at/Documents/workspace/interview 2/schi/RAW 2.txt");
		TreeMap<String, Integer> treemap1 = new TreeMap<String, Integer>();
		treemap1=(TreeMap<String, Integer>) tr1.result; 
		
		
		TreeMapDemo tr2=new TreeMapDemo();
		tr2.getWordGroupCount("/Users/at/Documents/workspace/interview 2/schi/RAW.txt");
		TreeMap<String, Integer> treemap2 = new TreeMap<String, Integer>();
		treemap2=(TreeMap<String, Integer>) tr2.result; 


		// Put elements to the map
		
		
		TreeMap<String, Integer> res = new TreeMap<String, Integer>();
		res=(TreeMap<String, Integer>) mergeMaps(treemap1,treemap2);
		Map sortedMap = sortByValues(res);
		Set set = sortedMap.entrySet();
		Iterator i = set.iterator();
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
		System.out.println(me.getKey() + " "+me.getValue());
		}
		

	}

}


/*	public static void mergeMaps(Map<String, Integer> tm1,Map<String, Integer> tm2) {
		Map sortedMap1 = tm1;
		Map sortedMap2 = tm2;
		Set set1 = sortedMap1.entrySet();
		Set set2 = sortedMap2.entrySet();
		Iterator it1 = set1.iterator();
		Iterator it2 = set1.iterator();
		while(it1.hasNext()){
			Map.Entry me1 = (Map.Entry) it1.next();
			String s1=(String) me1.getKey();
			while(it2.hasNext()){
				Map.Entry me2 = (Map.Entry) it2.next();
				String s2=(String) me2.getKey();
				if((result.containsKey(s1))&&(result.containsKey(s2))){
					int i=(int) me1.getValue();
					int j=(int) me2.getValue();
					result.put(s1,i+j);
				}else {
					result.put(s1,  (Integer) me1.getValue());
					result.put(s2,  (Integer) me1.getValue());
					
				}	}
			}
		}
		
		
		treemap.put("A", 5);
		treemap.put("B", 4);
		treemap.put("E", 2);
		treemap.put("C", 4);
		treemap.put("D", 3);
		treemap2.put("Ac", 7);
		treemap2.put("B", 48);
		treemap2.put("E", 2);
		treemap2.put("C", 4);
		treemap2.put("D", 3);
		treemap2.put("J", 3);
		
	*/