import java.util.*;

public class Kadane {
	
		 public static  int[] maxSubarray(int[] a) {
				    int local = 0;
				    int global = 0;
				    int start= 0;
				    int startIndex = 0;
				    int end = -1;

				    for(int i = 0; i < a.length; i++) {
				      if(0 > global +a[i]) {
				        startIndex = i+1;
				        global = 0;
				      }
				      else {
				        global += a[i];
				      }

				      if(global > local) {
				        local = global;
				        start= startIndex;
				        end = i;
				      }
				    }

				    if(start<= end) {
				      return Arrays.copyOfRange(a, start, end+1);
				    }

				    return null;
				  
		 }
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = { 1, 8, -3, -7, 2, 7, -1, 9 };
		arr=maxSubarray(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		

	}

}
/*
if (s == null || s.length() == 0) {  
    return null;  
}  


 
int max = 0;  // the length of max string  
int start = 0;  
int k = 0;  
for (int i = 1; i < s.length(); i++) {  
    for (int j = 0; j < s.length() - i; j++) {  
        if (s.charAt(j) == s.charAt(i + j)) {  
            k++;  
        } else {  
            k = 0;  
        }  
        if (k > max) {  
            max = k;  
            start = j - k + 1;  
        }  
    }  
}  
if (max > 0) {  
    System.out.println(max);  
    return s.substring(start, start + max);  
}  
return null;  


int local=0,global = 0;
int start=0,startIndex=0,end = 0;
						

 for(int i = 0; i < s.length(); i++) {
      if(0 > global +s.charAt(i)) {
        startIndex = i+1;
        global = 0;
      }
      else {
        global += s.charAt(i);
      }

      if(global > local) {
        local = global;
        start= startIndex;
        end = i;
      }
    }

    if(start<= end) {
      return s.substring(start,end+1);
    }
    else return null;*/

