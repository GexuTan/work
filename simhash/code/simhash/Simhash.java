package simhash;

/*
 * �޸Ĺ�ϣ����
 * ����ʹ����simhash����ֱ�ӽ������㣬�����޸����ɵĹ�ϣֵ�ĳ���
 * */

import java.math.BigInteger;
import java.util.StringTokenizer;

public class Simhash {
	private String tokens;

	public BigInteger strSimHash;
	private int hashbits = 256;

	// ��ϣ������λ���������޸�
	public Simhash(String tokens) {
		this.tokens = tokens;
		this.strSimHash = this.simHash();
	}

	public Simhash(String tokens, int hashbits) {
		this.tokens = tokens;
		this.hashbits = hashbits;
		this.strSimHash = this.simHash();
	}

	public BigInteger simHash() {
		int[] v = new int[this.hashbits];

		StringTokenizer stringTokens = new StringTokenizer(this.tokens);
		// ���ַ����ָ�ɷ��ţ����ƽ�һ�����ӷֳɵ��ʣ������Զ�����ķ������ʹ��רҵ�ķִʹ��ߵĽ�����д���֤
		while (stringTokens.hasMoreTokens()) {
			String temp = stringTokens.nextToken();
			BigInteger t = this.hash(temp);
			for (int i = 0; i < this.hashbits; i++) {
				BigInteger bitmask = new BigInteger("1").shiftLeft(i);
				if (t.and(bitmask).signum() != 0) {

					v[i] += 1;

				} else {
					v[i] -= 1;
				}
			}
		}
		BigInteger fingerprint = new BigInteger("0");
		for (int i = 0; i < this.hashbits; i++) {
			if (v[i] >= 0) {
				fingerprint = fingerprint.add(new BigInteger("1").shiftLeft(i));
			}
		}
		return fingerprint;
	}

	private BigInteger hash(String source) {
		if (source == null || source.length() == 0) {
			return new BigInteger("0");
		} else {
			char[] sourceArray = source.toCharArray();
			BigInteger x = BigInteger.valueOf(((long) sourceArray[0]) << 7);
			BigInteger m = new BigInteger("1000003");
			BigInteger mask = new BigInteger("2").pow(this.hashbits).subtract(new BigInteger("1"));
			for (char item : sourceArray) {
				BigInteger temp = BigInteger.valueOf((long) item);
				x = x.multiply(m).xor(temp).and(mask);
			}
			x = x.xor(new BigInteger(String.valueOf(source.length())));
			if (x.equals(new BigInteger("-1"))) {
				x = new BigInteger("-2");
			}
			return x;
		}
	}
}