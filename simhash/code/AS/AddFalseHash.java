package AS;

import simhash.FileOperation;
import simhash.RandomNumber;


public class AddFalseHash {
	
	int falseNumber;
	int falseLength;
	
	public  AddFalseHash(){
		
	}
	
	public  AddFalseHash(int n1,int n2){
		falseNumber=n1;
		falseLength=n2;
	}
	public boolean clientAddValue(){
		int size=falseNumber;//指定个数
		
		FileOperation fi=new FileOperation("clientH.txt");
		
		String ins[] = new String[size];
		
		for (int i = 0; i < size; i++) {
			RandomNumber nu=new RandomNumber();
			ins[i]=nu.RandomString(falseLength);
			// 任意长度的
		}
		fi.writFile("clientH.txt", ins,true);
		System.out.println("生成了"+size+"个任意属性");
		return true;
	}
	
	
	
	public boolean serverAddValue(){
		int size=falseNumber;//指定个数
		
		FileOperation fi=new FileOperation("serverH.txt");
		
		String ins[] = new String[size];
		
		for (int i = 0; i < size; i++) {
			RandomNumber nu=new RandomNumber();
			ins[i]=nu.RandomString(falseLength);
			// 任意长度的
		}
		fi.writFile("serverH.txt", ins,true);
		System.out.println("生成了"+size+"个任意属性");
		return true;
	}

}
