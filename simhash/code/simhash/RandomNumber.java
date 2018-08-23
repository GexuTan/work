package simhash;

import java.util.Random;
import java.lang.Math;
import java.math.BigInteger;

import ASsim.AddFalse;

public class RandomNumber {
	
	public String RandomString(int falseLength){

		Random random = new Random();
		int[] nu=new int[falseLength];
		String st=new String("");
		
		for (int i = 0; i < falseLength; i++) {
			nu[i]=new Random().nextInt(10);
			st=st+nu[i];
			System.out.println(st);
		}
		
		
		return st;
		}
}
