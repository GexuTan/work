package indi.sharing.key;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;


public class PrivateKeyFactory {

	public static PrivateKey getInstance(BigInteger p) {
		return new PrivateKey(p);
	}

	
	public static void saveKey(File file, PrivateKey key) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(key);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	
	public static PrivateKey readKey(File file) {
		PrivateKey key = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			key = (PrivateKey)ois.readObject();
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return key;
	}
}
