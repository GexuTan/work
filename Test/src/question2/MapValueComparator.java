package question2;


import java.util.Comparator;
import java.util.*;
import java.util.Map.Entry;

class MapValueComparator implements Comparator<Map.Entry<String, String>> {  
	  
    @Override  
    public int compare(Entry<String, String> me1, Entry<String, String> me2) {  
  
        return me1.getValue().compareTo(me2.getValue());  
    }  
}  