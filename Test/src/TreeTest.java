import java.util.*;

public class TreeTest {

	public static boolean equalIgnore(String s1, String s2) {
		return s1 == null ? s2 == null : s1.equalsIgnoreCase(s2);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String, Integer> tm1 = new TreeMap<String, Integer>();
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>(Collections.reverseOrder());

		Integer value = null;
		Collection c = tm.values();
		Iterator iter = c.iterator();

		String key = null;
		Integer integ = null;
		Iterator iter2 = tm.keySet().iterator();

		List<String> data = new ArrayList<String>();
		data.add("the");
		data.add("the");
		data.add("the");
		data.add("game");
		data.add("game");
		data.add("t");
		data.add("th");

		for (int i = 0; i < data.size(); i++) {
			String s1 = data.get(i) + "";
			String s2 = (String) iter2.toString();
			if (equalIgnore(s1, s2)) {
				value = (Integer) iter.next() + 1;
			} else {
				tm.put(s1, value + 1);
			}
		}

		while (iter.hasNext()) {
			value = (Integer) iter.next();

			key = (String) iter2.next();
			// 根据key，获取value
			integ = (Integer) tm1.get(key);

			System.out.println(key + value);
		}

	}

}
