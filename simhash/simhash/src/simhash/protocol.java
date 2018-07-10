package simhash;
import java.math.BigInteger;

public class protocol {

	public static void main(String[] args) {
		long a = System.currentTimeMillis();//��ʼ����ʱ��

		
		int s=10000;//�����޸�
		String fileNameR="effi/RrawAttris"+s+".txt";
		String fileNameS="effi/SrawAttris"+s+".txt";
		//��ԭʼ�����ļ�
		
		
		String insR[] = new String[s];
		String insS[] = new String[s];
		FileOperation filR=new FileOperation();
		FileOperation filS=new FileOperation();
		insR=filR.readFile((fileNameR),s);
		insS=filS.readFile((fileNameS),s);
		//��ȡ�ļ���������ȥ
		
		
		String inshashR[]= new String[s];
		for(int i=0;i<insR.length;i++){
			Simhash hash = new Simhash(insR[i], 256);
			BigInteger bi = hash.strSimHash;
			String s2 = bi.toString();
			inshashR[i]=s2;
		}
		
		
		String inshashS[]= new String[s];
		for(int i=0;i<insS.length;i++){
			Simhash hash = new Simhash(insS[i], 256);
			BigInteger bi = hash.strSimHash;
			String s2 = bi.toString();
			inshashS[i]=s2;
		}
		
		filR.writFile("effi/HA"+s+".txt", insR,inshashR);
		filS.writFile("effi/HA"+s+".txt", insS,inshashS);
		
		filR.writFile("effi/RH"+s+".txt", inshashR);
		filS.writFile("effi/RH"+s+".txt", inshashS);
		
		double ratio = 0.5;
		Ratio ra=new Ratio();
		int count=ra.calRatio(s, ratio);
		
		
		
		System.out.println("R����"+count+"��������ͬ");
	
		System.out.println("\r<br>ִ�к�ʱ : "+ (System.currentTimeMillis() - a) / 1000f + " �� ");//��������ʱ��
	}
}
