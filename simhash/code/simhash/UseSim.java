package simhash;

/*
 * ���ı�ʹ��simhash��ָ��λ����hashֵ
 * �����������ı��ļ������hash�ļ������hash�������ļ������Ը�������ϣλ��
 * ���ܣ�����������ļ�
 * */

import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public class UseSim {
	public void useSim(String inputfile,String outputfile,String outHA,int s,int hashnum){
	//public static void main(String[] args) throws Exception {
		{
			long a = System.currentTimeMillis();
			String ins[] = new String[s];
			String inshash[]= new String[s];
			
			FileOperation fil=new FileOperation();
			ins=fil.readFile((inputfile),s);	
			
			for(int i=0;i<ins.length;i++){
				Simhash hash = new Simhash(ins[i],hashnum);
				BigInteger bi = hash.strSimHash;
				String s2 = bi.toString();
				inshash[i]=s2;
			}
			
			fil.writFile(outHA, ins,inshash);
			fil.writFile(outputfile, inshash);
			
			System.out.println("������");
			System.out.println("\r<br>ִ�к�ʱ : "+ (System.currentTimeMillis() - a) / 1000f + " �� ");
		}
	}
}
