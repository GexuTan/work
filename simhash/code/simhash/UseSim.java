package simhash;

/*
 * 对文本使用simhash，指定位数的hash值
 * 参数：输入文本文件，输出hash文件，输出hash＋属性文件，属性个数，哈希位数
 * 功能：将结果存入文件
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
			
			System.out.println("结束了");
			System.out.println("\r<br>执行耗时 : "+ (System.currentTimeMillis() - a) / 1000f + " 秒 ");
		}
	}
}
