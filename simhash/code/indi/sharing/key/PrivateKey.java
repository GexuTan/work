package indi.sharing.key;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 */
public class PrivateKey implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private BigInteger a; //
	private BigInteger b; //
	private BigInteger p; //
	private SecureRandom random ;
	private static final String ALGORITHM2 ="SHA1PRNG";

	public String toString() {
		return "a: " + a + "\n" + "b: " + b + "\n" + "p: " + p;

	}

	/**
	
	 */
	public static BigInteger encryp(BigInteger plainttext, PrivateKey key) {
		if (plainttext.compareTo(BigInteger.ZERO) == -1) {
			plainttext = plainttext.negate();
			return plainttext.modPow(key.a, key.p).negate();
		} else {
			return plainttext.modPow(key.a, key.p);
		}
	}

	/**
	 *
	 */
	public static BigInteger encryp(byte[] plainttext, PrivateKey key) {
		BigInteger temp = new BigInteger(plainttext);
		if (temp.compareTo(BigInteger.ZERO) == -1) {
			temp = temp.negate();
			return temp.modPow(key.a, key.p).negate();
		} else {
			return temp.modPow(key.a, key.p); 
		}

	}

	/**
	 *
	 */
	public static BigInteger decryp(BigInteger ciphertext, PrivateKey key) {
		if (ciphertext.compareTo(BigInteger.ZERO) == -1) { 
			ciphertext = ciphertext.negate();
			return ciphertext.modPow(key.b, key.p).negate(); 
		} else {
			return ciphertext.modPow(key.b, key.p); 
		}
	}


	
	PrivateKey(BigInteger p) {
		try {
			this.random = SecureRandom.getInstance(ALGORITHM2);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] randomBytes = new byte[64];
		BigInteger tempa = null;
		this.p = p;
		while(true){
			this.random.nextBytes(randomBytes);
			tempa = new BigInteger(randomBytes);
			
			if(((tempa.gcd(p.subtract(BigInteger.ONE))).compareTo(BigInteger.ONE))==0 && tempa.compareTo(p)== -1){
				this.a = tempa;
				break;
			}
		}
	
		this.b = this.a.modInverse(p.subtract(BigInteger.ONE));
	}


	/**
	 *
	 */
	public boolean isCommonPrimePKey(PrivateKey key, BigInteger p) {
		if (key.p.compareTo(p) == 0)
			return true;
		else
			return false;
	}

	public boolean isGenByPrimeP(BigInteger P) {
		if (this.p.equals(p)) {
			return true;
		} else {
			return false;
		}
	}
}
