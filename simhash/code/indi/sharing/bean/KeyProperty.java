package indi.sharing.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import indi.sharing.SP.GenPublicPrimeP;

public class KeyProperty {
	//public BigInteger p;
	
	private File primaryKey;
	private File secondaryKey;
	
	
	public File getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(File primaryKey) {
		this.primaryKey = primaryKey;
	}
	public File getSecondaryKey() {
		return secondaryKey;
	}
	public void setSecondaryKey(File secondaryKey) {
		this.secondaryKey = secondaryKey;
	}
	public KeyProperty(File primaryKey, File secondaryKey) {
		super();
		this.primaryKey = primaryKey;
		this.secondaryKey = secondaryKey;
	}

}