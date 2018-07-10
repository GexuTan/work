import java.io.*;

public class main {
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in); 
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
		}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in); 
		BufferedReader br = new BufferedReader(isr);
		System.out.println(br.toString());
		String s = br.readLine();
		System.out.println(s);
		
	}
}
