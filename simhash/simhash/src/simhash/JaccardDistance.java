package simhash;

import java.util.ArrayList;  
import java.util.Arrays;  
import java.util.Collections;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
import java.util.Set;  
  
public class JaccardDistance {  
	
	private int compare(String str, String target) {

		int d[][]; // 矩阵

		int n = str.length();

		int m = target.length();

		int i; // 遍历str的

		int j; // 遍历target的

		char ch1; // str的

		char ch2; // target的

		int temp; // 记录相同字符,在某个矩阵位置值的增量,不是0就是1

		if (n == 0) {

			return m;

		}

		if (m == 0) {

			return n;

		}

		d = new int[n + 1][m + 1];

		for (i = 0; i <= n; i++) { // 初始化第一列

			d[i][0] = i;

		}

		for (j = 0; j <= m; j++) { // 初始化第一行

			d[0][j] = j;

		}

		for (i = 1; i <= n; i++) { // 遍历str

			ch1 = str.charAt(i - 1);

			// 去匹配target

			for (j = 1; j <= m; j++) {

				ch2 = target.charAt(j - 1);

				if (ch1 == ch2) {

					temp = 0;

				} else {

					temp = 1;

				}

				// 左边+1,上边+1, 左上角+temp取最小

				d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1]

				+ temp);

			}

		}

		return d[n][m];

	}
	
	
	
	

	private int min(int one, int two, int three) {

		return (one = one < two ? one : two) < three ? one : three;

	}


	public float getSimilarityRatio(String str, String target) {

		return 1 - (float) compare(str, target)
				/ Math.max(str.length(), target.length());

	}
	
	
	
	/*
    public static Map<String, Double> weightMap = new HashMap<String, Double>();  
  
    public static List<String> intersection(String source, String target) {  
        List<String> slist = Arrays.asList(source.split(" "));  
        List<String> tlist = Arrays.asList(target.split(" "));  
        List<String> intersection = new ArrayList<String>();          
          
        for (String s: slist) {  
            if (tlist.contains(s)) {  
                if (!intersection.contains(s)) {  
                    intersection.add(s);  
                }  
            }  
        }  
          
        return intersection;  
    }/*  
    /*
    //J(s,t) = 1 - intersection(s, t).size()) / (s.size() + t.size() - intersection.size())    
	
    public static double Jaccard1(String source, String target) {  
        List<String> slist = Arrays.asList(source.split(" "));  
        List<String> tlist = Arrays.asList(target.split(" "));  
        List<String> intersection = intersection(source, target);       
          
        return (double) 1 - intersection.size() / (double)(slist.size() + tlist.size() - intersection.size());  
    } 
      
    //   J(s,t) = 1 - 2 * intersection(s, t).size()) / (s.size() + t.size()) 
     
	
    public static double Jaccard2(String source, String target) {  
        List<String> slist = Arrays.asList(source.split(" "));  
        List<String> tlist = Arrays.asList(target.split(" "));  
        List<String> intersection = intersection(source, target);           
          
        return (double) 1 - 2 * intersection.size() / (double)(slist.size() + tlist.size());  
    }  /*
      
    // J(s,t) each token has weight value. 
    /* 
    public static void JaccardWeight(List<String> stringList) {  
        Map<String, Integer> freqMap = new HashMap<String, Integer>();  
          
        for (String string : stringList) {  
            List<String> slist = Arrays.asList(string.split(" "));  
            for (String s : slist)  {  
                s = s.trim();  
                if (freqMap.containsKey(s)) {  
                    freqMap.put(s, freqMap.get(s)+1);  
                } else {  
                    freqMap.put(s, 1);  
                }  
            }  
        }  
          
        for (String key : freqMap.keySet()) {  
            int freq = freqMap.get(key);  
            double weight = (double) 1 / (Math.log(freq) + 1);  
            weightMap.put(key, weight);  
        }         
//      return weightMap;         
    }  /*
      
     /*
    public static double Jaccard3(String source, String target) {  
        List<String> slist = Arrays.asList(source.split(" "));  
        List<String> tlist = Arrays.asList(target.split(" "));  
        List<String> intersection = intersection(source, target);  
          
        double intersectionWeight = 0;  
        double sourceWeight = 0;  
        double targetWeight = 0;  
        for (String s : intersection) {  
            intersectionWeight += weightMap.get(s);  
        }  
        for (String s : slist) {  
            sourceWeight += weightMap.get(s);  
        }  
        for (String s: tlist) {  
            targetWeight += weightMap.get(s);  
        }  
          
        return 1 - 2 * intersectionWeight / (sourceWeight + targetWeight);  
    }  */
      
   
    public static void main(String[] args) {  
    	
        String s1 = "4194457199398869193";
        String s2 =	"3320979932790895809";
        System.out.println(s1.length());
        
        
        String s3 ="2555927023173162054311496";
        String s4 ="2555927023173106078099520";
        System.out.println(s3.length());
        String s5 ="2921379066820837240759804897444";
        String s6 ="2921379066820837240736548871724";
        System.out.println(s5.length());

        String s7 ="3213488210610298011944627942084201619";
        String s8 ="3213488210610298011944627900428079739";
        System.out.println(s7.length());
        String s9 = "211460240507932354017316438609274525662";
        String s10 ="211460240507932354017316438585394450934";
        System.out.println(s9.length());
        String s11 ="224460075851279720089294700433610320682";
        String s12 ="224460075851279720089294700475778490178";
        
        System.out.println(s11.length());
        JaccardDistance jd=new JaccardDistance();
        System.out.println("J1(s1, s2) = " +jd.getSimilarityRatio(s1, s2));  
        System.out.println("J1(s1, s3) = " + jd.getSimilarityRatio(s3, s4));  
        System.out.println("J1(s2, s3) = " + jd.getSimilarityRatio(s5, s6));  
  
        System.out.println("J1(s1, s2) = " +jd.getSimilarityRatio(s7, s8));  
        System.out.println("J1(s1, s3) = " + jd.getSimilarityRatio(s9, s10));  
        System.out.println("J1(s2, s3) = " + jd.getSimilarityRatio(s11, s12));  
        
    }  
  
}  