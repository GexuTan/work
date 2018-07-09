package question3;

import java.util.HashSet;
import java.util.Iterator;

public class LargestSum {

	public static int maxSubarray(int[] arr) {

		int local = arr[0];
		int global = arr[0];
		for (int i = 1; i < arr.length; i++) {
			local = Math.max(arr[i], local + arr[i]);
			global = Math.max(global, local);
		}
		return global;
	}

	public static void main(String[] args) {
		int arr[] = { -10, -8, -3, -7, -2, -7, -3, -9 };
		System.out.println(maxSubarray(arr));

	}
}
