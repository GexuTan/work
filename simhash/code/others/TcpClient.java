package others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.	*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TcpClient
{
	 private final static Logger logger = Logger.getLogger(TcpClient.class.getName());  
     
	    public static void main(String[] args) throws Exception {  
	        for (int i = 0; i < 100; i++) {  
	            Socket socket = null;  
	            ObjectOutputStream os = null;  
	            ObjectInputStream is = null;  
	              
	            try {  
	                socket = new Socket("localhost", 10000);  
	      
	                os = new ObjectOutputStream(socket.getOutputStream());  
	                User user = new User("user_" + i, "password_" + i);  
	                os.writeObject(user);  
	                os.flush();  
	                  
	                is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));  
	                Object obj = is.readObject();  
	                if (obj != null) {  
	                    user = (User)obj;  
	                    System.out.println("user: " + user.getName() + "/" + user.getPassword());  
	                }  
	            } catch(IOException ex) {  
	                logger.log(Level.SEVERE, null, ex);  
	            } finally {  
	                try {  
	                    is.close();  
	                } catch(Exception ex) {}  
	                try {  
	                    os.close();  
	                } catch(Exception ex) {}  
	                try {  
	                    socket.close();  
	                } catch(Exception ex) {}  
	            }  
	        }  
	    }  

}

