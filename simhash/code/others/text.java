package others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class text {
	/**
	 * ѧ�ܵĴ���
	 * ��ʱ���ù�
	 * 
	 * ������ʱ�Ự��Կ����Կ����ʹ��Ĭ�ϳ���
	 * @param algorithm - ��Կ�����㷨,����Blowfish,DES,DESede, HmacMD5,HmacSHA1,AES��
	 * @return - �������ɵ���ʱ�Ự��Կ
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static byte[] generateSessionKey(String algorithm)
			throws NoSuchAlgorithmException, IOException {
		KeyGenerator kg = KeyGenerator.getInstance(algorithm); //���ü����㷨
		SecretKey k = kg.generateKey(); //������Կ
		String s = new String(k.getEncoded());
		System.out.println(s);
		FileOutputStream f = new FileOutputStream("ClientKey\\session_Key.dat"); //��ʱ��Կ����ڱ�����Կ��������
		ObjectOutputStream b = new ObjectOutputStream(f);
		b.writeObject(k); //�Զ���ķ�ʽ�洢��Կ
		b.close();

		byte [] keyBytes = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(k);
		oos.close();
		keyBytes = baos.toByteArray(); //��Կkeyת��Ϊ�ֽ�����
		return keyBytes;
	}

public static void encryptSessionKey(String key)
			throws ClassNotFoundException, IOException {
		FileInputStream f = new FileInputStream("KeyManageCenter\\Client_RSA_pub.dat"); //��ȡ��Կ
		ObjectInputStream b = new ObjectInputStream(f);
		RSAPublicKey pbk = (RSAPublicKey)b.readObject();
		b.close();
		BigInteger e = pbk.getPublicExponent(); //��ȡe
		BigInteger n = pbk.getModulus(); //��ȡn
		System.out.println("e=" + e);
		System.out.println("n=" + n);

		//���л�����ת��Ϊ�ֽ�����
		byte [] keyBytes = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(key);
		keyBytes = baos.toByteArray(); //��Կkeyת��Ϊ�ֽ�����
		oos.close();

		BigInteger m = new BigInteger(keyBytes); //Ҫ���ܵ����ģ��˴�Ϊ�Ự��Կ
		System.out.println("����ʱҪ���ܵ�����m:" + m); //------------------------------
		BigInteger c = m.modPow(e, n); //�õ����ܽ��
		System.out.println("����ʱ���ܺ������c:" + c);
		String cs = c.toString();
		BufferedWriter out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("Enc_RSA.dat")));
		out.write(cs, 0, cs.length());
		out.close();
	}

public static String decryptSessionKey()
			throws IOException, ClassNotFoundException {
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("Enc_RSA.dat")));
		String ctext = in.readLine(); //��ȡ���ģ��˴�Ϊ���ܺ�ĻỰ��Կ
		in.close();
		BigInteger c = new BigInteger(ctext); //����ת��ΪBigInteger
		FileInputStream f = new FileInputStream("ClientKey\\Client_RSA_priv.dat"); //��ȡRSA˽Կ
		ObjectInputStream b = new ObjectInputStream(f);
		RSAPrivateKey prk = (RSAPrivateKey)b.readObject(); 
		b.close();
		BigInteger d = prk.getPrivateExponent(); //��ȡd
		BigInteger n = prk.getModulus(); //��ȡn
		System.out.println("d=" + d);
		System.out.println("n=" + n);
		BigInteger m = c.modPow(d, n); //���ܵõ�����
		System.out.println("����ʱҪ���ܵ�����c:" + c);
		System.out.println("����ʱ���ܺ������m:" + m);
		byte[] mb = m.toByteArray();
		//�ֽ�����ת��Ϊ����
		ByteArrayInputStream bi = new ByteArrayInputStream(mb);   
		ObjectInputStream oi = new ObjectInputStream(bi);
		String key = (String) oi.readObject();
		return key;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
