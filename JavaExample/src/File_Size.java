import java.io.*;
public class File_Size{
     public static void main(String args[])throws IOException{ 
         File files=new File(".");
         listPath(files);
     }   
     public static void listPath(File f)throws IOException{
   	String file_list[]=f.list();
           for(int i=0;i<file_list.length;i++){
                File current_file=new File(f.getPath(),file_list[i]);
                if(current_file.isDirectory()) {
                   listPath(current_file);
                }
                if(current_file.isFile()){      
                  try{
	                                                              System.out.println(current_file.getCanonicalPath()+":"+current_file.length());      
                 }catch(IOException e){
           	 e.printStackTrace();
                }      
           }//if
       }//for
   }  
}
