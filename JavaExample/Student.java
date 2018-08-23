import java.io.*;
import java.util.*;

public class Student {
	String name;
	long stno;
	String sex;

	public Student(String name, long stno, String sex) {
		this.name = name;
		this.stno = stno;
		this.sex = sex;
	}

	public String toString() {
		return "姓名:" + name + ",学号:" + stno + ",性别=" + sex;
	}

	public static void main(String args[]) {
		Vector group = new Vector();
		outer: while (true) {
			String ch = input("选择:1-- 增加, 2---删除, 3- 显示,4--退出");
			int choice = Integer.parseInt(ch);
			switch (choice) {
			case 1:
				group.add(inputStudent());
				break;
			case 2:
				long stno = Long.parseLong(input("请输入学号:"));
				for (int k = 0; k < group.size(); k++) {
					Student x = (Student) group.get(k);
					if (x.stno == stno)
						group.removeElement(x);
				}
				break;
			case 3:
				Iterator p = group.iterator();
				while (p.hasNext())
					System.out.println("==>" + p.next());
				break;
			case 4:
				break outer;
			}
		}
	}

	/* 从键盘输入一个字符串 */
	public static String input(String hint) {
		String x = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(hint);
		try {
			x = br.readLine();
		} catch (IOException e) {
		}
		return x;
	}

	/* 从键盘输入一个学生 */
	public static Student inputStudent() {
		String name = input("请输入姓名:");
		long stno = Long.parseLong(input("请输入学号:"));
		String sex = input("请输入性别:");
		return new Student(name, stno, sex);
	}
}
