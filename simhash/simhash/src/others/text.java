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
	 * 学弟的代码
	 * 暂时不用管
	 * 
	 * 生成临时会话秘钥，秘钥长度使用默认长度
	 * @param algorithm - 秘钥生成算法,包括Blowfish,DES,DESede, HmacMD5,HmacSHA1,AES等
	 * @return - 返回生成的临时会话秘钥
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static byte[] generateSessionKey(String algorithm)
			throws NoSuchAlgorithmException, IOException {
		KeyGenerator kg = KeyGenerator.getInstance(algorithm); //设置加密算法
		SecretKey k = kg.generateKey(); //产生秘钥
		String s = new String(k.getEncoded());
		System.out.println(s);
		FileOutputStream f = new FileOutputStream("ClientKey\\session_Key.dat"); //临时秘钥存放在本地秘钥管理中心
		ObjectOutputStream b = new ObjectOutputStream(f);
		b.writeObject(k); //以对象的方式存储秘钥
		b.close();

		byte [] keyBytes = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(k);
		oos.close();
		keyBytes = baos.toByteArray(); //秘钥key转换为字节数组
		return keyBytes;
	}

public static void encryptSessionKey(String key)
			throws ClassNotFoundException, IOException {
		FileInputStream f = new FileInputStream("KeyManageCenter\\Client_RSA_pub.dat"); //读取公钥
		ObjectInputStream b = new ObjectInputStream(f);
		RSAPublicKey pbk = (RSAPublicKey)b.readObject();
		b.close();
		BigInteger e = pbk.getPublicExponent(); //获取e
		BigInteger n = pbk.getModulus(); //获取n
		System.out.println("e=" + e);
		System.out.println("n=" + n);

		//序列化对象转换为字节数组
		byte [] keyBytes = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(key);
		keyBytes = baos.toByteArray(); //秘钥key转换为字节数组
		oos.close();

		BigInteger m = new BigInteger(keyBytes); //要加密的明文，此处为会话秘钥
		System.out.println("加密时要加密的明文m:" + m); //------------------------------
		BigInteger c = m.modPow(e, n); //得到加密结果
		System.out.println("加密时加密后的密文c:" + c);
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
		String ctext = in.readLine(); //读取密文，此处为加密后的会话秘钥
		in.close();
		BigInteger c = new BigInteger(ctext); //密文转换为BigInteger
		FileInputStream f = new FileInputStream("ClientKey\\Client_RSA_priv.dat"); //读取RSA私钥
		ObjectInputStream b = new ObjectInputStream(f);
		RSAPrivateKey prk = (RSAPrivateKey)b.readObject(); 
		b.close();
		BigInteger d = prk.getPrivateExponent(); //获取d
		BigInteger n = prk.getModulus(); //获取n
		System.out.println("d=" + d);
		System.out.println("n=" + n);
		BigInteger m = c.modPow(d, n); //解密得到明文
		System.out.println("解密时要解密的密文c:" + c);
		System.out.println("解密时解密后的明文m:" + m);
		byte[] mb = m.toByteArray();
		//字节数组转换为对象
		ByteArrayInputStream bi = new ByteArrayInputStream(mb);   
		ObjectInputStream oi = new ObjectInputStream(bi);
		String key = (String) oi.readObject();
		return key;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
