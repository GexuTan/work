package simhash;

/*
 * ����ʹ����simhash����ֱ�ӽ�������
 * */
 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SSimhash
{
    private String tokens;
    //����
    private BigInteger strSimHash;
    private int hashbits = 128;
    //��ϣ������λ����Ĭ�ϵģ���ʼ��
    public SSimhash(String tokens)
    {
        this.tokens = tokens;
        this.strSimHash = this.simHash();
    }
//ָ����ϣ������λ������ʼ��    
    public SSimhash(String tokens, int hashbits)
    {
        this.tokens = tokens;
        this.hashbits = hashbits;
        this.strSimHash = this.simHash();
    }

    public BigInteger simHash()
    {
        int[] v = new int[this.hashbits];
        //����
        StringTokenizer stringTokens = new StringTokenizer(this.tokens);
        //���ַ����ָ�ɷ��ţ����ƽ�һ�����ӷֳɵ��ʣ������Զ�����ķ������ʹ��רҵ�ķִʹ��ߵĽ�����д���֤
        while (stringTokens.hasMoreTokens())
        {
            String temp = stringTokens.nextToken();
            BigInteger t = this.hash(temp);
            for (int i = 0; i < this.hashbits; i++)
            {
            	//System.out.println(temp);	
            	//System.out.println(t);	
                BigInteger bitmask = new BigInteger("1").shiftLeft(i);
                if (t.and(bitmask).signum() != 0)
                {
                	//System.out.println(v[i]);	
                    v[i] += 1;
                    
                }
                else
                {
                    v[i] -= 1;
                }
            }
        }
        BigInteger fingerprint = new BigInteger("0");
        for (int i = 0; i < this.hashbits; i++)
        {
            if (v[i] >= 0)
            {
                fingerprint = fingerprint.add(new BigInteger("1").shiftLeft(i));
            }
        }
        return fingerprint;
    }
    
    
    private BigInteger hash(String source)
    {
        if (source == null || source.length() == 0)
        {
            return new BigInteger("0");
        }
        else
        {
            char[] sourceArray = source.toCharArray();
            BigInteger x = BigInteger.valueOf(((long) sourceArray[0]) << 7);
            BigInteger m = new BigInteger("1000003");
            BigInteger mask = new BigInteger("2").pow(this.hashbits).subtract(
                new BigInteger("1"));
            for (char item : sourceArray)
            {
                BigInteger temp = BigInteger.valueOf((long) item);
                x = x.multiply(m).xor(temp).and(mask);
            }
            x = x.xor(new BigInteger(String.valueOf(source.length())));
            if (x.equals(new BigInteger("-1")))
            {
                x = new BigInteger("-2");
            }
            return x;
        }
    }
    
    
    public int hammingDistance(SSimhash other)
//���ڼ���hamming����
    {
        BigInteger m = new BigInteger("1").shiftLeft(this.hashbits).subtract(
            new BigInteger("1"));
        BigInteger x = this.strSimHash.xor(other.strSimHash).and(m);
        int tot = 0;
        while (x.signum() != 0)
        {
            tot += 1;
            x = x.and(x.subtract(new BigInteger("1")));
        }
        return tot;
    }
    
    public static void main(String[] args) throws Exception{
    {
    	
    	//��3���ļ�
    	long a=System.currentTimeMillis();
    	BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("rawAttri10000.txt"),"UTF-8"));  
    
        FileOutputStream fos=new FileOutputStream("hashAtt10000.txt");
        OutputStreamWriter oos=new OutputStreamWriter(fos,"UTF-8");
        FileOutputStream fos1=new FileOutputStream("rawHash10000.txt");
        OutputStreamWriter oos1=new OutputStreamWriter(fos1,"UTF-8");
       //���ļ�input���뵽������ȥ
        String ins[]=new String[10000]; 
        int len=0;
        String s3="";
        //�ڶ���ĩβ֮ǰ 
        while((s3=br.readLine())!=null){
        	if(((s3!="\r")&&((s3)!="\n")&&((s3)!="\t")))
        	{
        		ins[len]=s3;
            	System.out.println("��ȡ��"+len+"����Ӧֵ "+ins[len]);
            	SSimhash hash = new SSimhash(s3,128);
            	System.out.println(hash.strSimHash + ":"+ hash.strSimHash.bitLength());
            	BigInteger bi=hash.strSimHash;
            	String s2=bi.toString();
            	oos.append(s3);
            	oos.write("\r\n");
            	oos.append(s2);
            	oos.write("\r\n");
            	oos1.append(s2);
            	oos1.write("\r\n");
        		len++;
        	}
        }
        oos.close();
        oos1.close();
	    fos.close();
	    fos1.close();
	    br.close();
	    System.out.println("������");
	    System.out.println("\r<br>ִ�к�ʱ : "+(System.currentTimeMillis()-a)/1000f+" �� ");
    }
    }
}      