package simhash;

/*
 * 输入两个字符串，输出它们的近似率
 * 
 * 
 * 
 * Levenshtein 距离，又称编辑距离，指的是两个字符串之间，
 * 由一个转换成另一个所需的最少编辑操作次数。许可的编辑操作包括
 * 将一个字符替换成另一个字符，插入一个字符，删除一个字符。
 * */
public class Levenshtein {

	private int compare(String str, String target) {

		int d[][]; // 矩阵

		int n = str.length();

		int m = target.length();

		int i; // 遍历str的

		int j; // 遍历target的

		char ch1; // str的

		char ch2; // target的

		int temp; // 记录相同字符,在某个矩阵位置值的增量,不是0就是1

		if (n == 0) {

			return m;

		}

		if (m == 0) {

			return n;

		}

		d = new int[n + 1][m + 1];

		for (i = 0; i <= n; i++) { // 初始化第一列

			d[i][0] = i;

		}

		for (j = 0; j <= m; j++) { // 初始化第一行

			d[0][j] = j;

		}

		for (i = 1; i <= n; i++) { // 遍历str

			ch1 = str.charAt(i - 1);

			// 去匹配target

			for (j = 1; j <= m; j++) {

				ch2 = target.charAt(j - 1);

				if (ch1 == ch2) {

					temp = 0;

				} else {

					temp = 1;

				}

				// 左边+1,上边+1, 左上角+temp取最小

				d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1]

				+ temp);

			}

		}

		return d[n][m];

	}

	private int min(int one, int two, int three) {

		return (one = one < two ? one : two) < three ? one : three;

	}


	public float getSimilarityRatio(String str, String target) {

		return 1 - (float) compare(str, target)
				/ Math.max(str.length(), target.length());

	}

}