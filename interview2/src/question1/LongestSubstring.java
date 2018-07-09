package question1;

import java.util.HashMap;

public class LongestSubstring {

	public static String findLongestString(String str) {
		StringBuilder max = new StringBuilder("");
		char[] ch = str.toCharArray();
		HashMap<Character, Integer> charsIndex = new HashMap<Character, Integer>();
		int start = -1, oristart = start, maxLen = 0;
		for (int index = 0; index < ch.length; index++) {
			if (charsIndex.containsKey(ch[index])) {
				int oriIndex = charsIndex.get(ch[index]);
				if (oriIndex > start) {
					start = oriIndex;
				}
			}
			if (index - start > maxLen) {
				maxLen = index - start;
				oristart = start;
			}
			charsIndex.put(ch[index], index);
		}
		for (int index = oristart + 1; index < oristart + maxLen + 1; index++) {
			max.append(ch[index]);
		}
		return max.toString();
	}

	public static void main(String[] args) {
		String s = findLongestString("bbbbbbbb");
		System.out.println(s);
	}
}
