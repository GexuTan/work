package indi.sharing.SP;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;


/**
 * SP generates the big prime p that is used to generate key pairs for users
 * 
 */
public class GenPublicPrimeP {
	private static final String ALGORITHM = "RSA"; //use RSA to generate prime
	private KeyPairGenerator kpg;
	private PrivateKey pk;
	private RSAPrivateCrtKey rsapck;
	private BigInteger P;					

	private GenPublicPrimeP(int sed) {
		try {
			this.kpg = KeyPairGenerator.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		init(1024);
	}

	public static BigInteger getSecurePrime(int sed) {
		return new GenPublicPrimeP(sed).P;
	}

	private void init(int sed){
		SecureRandom sr = new SecureRandom();
		this.kpg.initialize(sed, sr);
		KeyPair kpair = this.kpg.genKeyPair();
		this.pk = kpair.getPrivate();
		this.rsapck = (RSAPrivateCrtKey) (RSAPrivateKey) this.pk;
		this.P = this.rsapck.getPrimeP();		//
	}

	public static void savePrimeP(File file, BigInteger P) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(file));
			oos.writeObject(P);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static BigInteger readPrimeP(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		BigInteger p = null;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		p =  (BigInteger) ois.readObject();
		ois.close();
		return p;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
