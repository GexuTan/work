package simhash;

import java.math.BigInteger;

public class CreateCipher {
	
	String sharedFile;
	int number;
	long time;
	
	public CreateCipher(){
		
	}
	
	public CreateCipher(String s1,int n1) {
		
		sharedFile=s1;
		number=n1;
	}
	
	public long getTime(){
		return time;
	}
	public boolean isSuccess(String sharedFile,int number){
		long a = System.currentTimeMillis();//��ʼ����ʱ��	
		
		String fileNameR=sharedFile+".txt";
		//��ԭʼ�����ļ�
		
		String insR[] = new String[number];
		
		FileOperation filR=new FileOperation();
		
		insR=filR.readFile((fileNameR),number);
		
		//��ȡ�ļ���������ȥ
		
		
		String inshashR[]= new String[number];
		for(int i=0;i<insR.length;i++){
			Simhash hash = new Simhash(insR[i], 256);
			BigInteger bi = hash.strSimHash;
			String s2 = bi.toString();
			inshashR[i]=s2;
		}
		filR.writFile("AH.txt", insR,inshashR);
		filR.writFile("H.txt", inshashR);
		
		long b= (long) ((System.currentTimeMillis() - a) / 1000f);
		time=b;
		System.out.println("\r<br>ִ�к�ʱ : "+b  + " �� ");//��������ʱ��
		return true;
	}
}
