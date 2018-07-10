import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class TreeT2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		TreeMap<String,Integer> tm2 = new TreeMap<String,Integer>(Collections.reverseOrder());
		
		 tm2.put("the", 3);
		 tm2.put("game", 1);
		 tm2.put("is", 1);
		 tm2.put("is", 1);
		 
		 //value
		 Integer value = null;
		 Collection c = tm2.values();
		 Iterator iter= c.iterator();
		 
		 //key
		 String key = null;
		 Integer integ = null;
		 Iterator iter2 = tm2.keySet().iterator();
		 
		
		 
		 
		 while (iter.hasNext()) {
		     value = (Integer)iter.next();
		     
		     key = (String)iter2.next();
		        // 根据key，获取value
		    integ = (Integer)tm2.get(key);
		    
		     System.out.println(key+value);
		 }
		 
		
		
		 
	}

}
