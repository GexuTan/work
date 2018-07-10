import java.awt.List;
//import java.util.*;




public class Solution {

	public static double findMaxAverage(int[] nums, int k) {

		int local = 0;
		int global = 0;

		for(int i=0;i<k;i++){
			local=local+nums[i];
		}
		global=local;
		
		for (int i = 0; i < nums.length-k; i++) {
			local = local+nums[i+k]-nums[i];
			global = Math.max(global, local);
		}
		return (double)global/k;
	}
	


	public static void main(String[] args) {
		
		double s= 6154.11+693.43;
		
		System.out.println(s);
		//System.out.println(s1);
		//System.out.println(s2);
		//System.out.println(s+s1+s2);
	}
}