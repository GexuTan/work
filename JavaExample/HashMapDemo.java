import java.util.*;
public class HashMapDemo {
public static void main(String[] args) {
     Map map=new HashMap();
     map.put("c", "ccc");
     map.put("a", "aaa");
     map.put("b", "bbb");
     map.put("d", "ddd");
    Iterator iter=map.keySet().iterator();
    while(iter.hasNext()){
       Object key=iter.next();
       System.out.println("map key "+key.toString()+" value="+map.get(key));  
    }
    TreeMap tab=new TreeMap();
    tab.put("a", "aaa");   
    tab.put("c", "ccc");
    tab.put("d", "ddd");
    tab.put("b", "bbb");
    Iterator iter2=tab.keySet().iterator();
    while(iter2.hasNext()){
       Object key=iter2.next();
       System.out.println("tab key "+key.toString()+" value="+tab.get(key)); 
    }
  } 
}
