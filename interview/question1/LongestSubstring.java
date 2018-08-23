package question1;

import java.util.*;

public class LongestSubstring {
	jfk
	public static String LongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return null;

		HashSet<Character> set = new HashSet<Character>();
		String global = "";
        String local = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                local = "";
                set.clear();
            }
            local += c;
            set.add(c);
            if (local.length() > global.length()) {
                global = local;
            }
        }
        return global;
	}
	
	
	
	public static void main(String[] args) {
		String s = LongestSubstring("abcduiii");
		System.out.println(s);
	}
}