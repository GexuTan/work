import java.io.*;
import java.util.*;
public class File_ex{ 
    void FileInformation(File f){
         System.out.println(f.getName());
         System.out.println(f.getAbsolutePath());
         System.out.println(f.getParent());
         System.out.println(f.length());
         System.out.println(new Date(f.lastModified()));
    }
    void DirectoryInformation(File d){
        System.out.println(d.getName());
        System.out.println(d.getParent());
        int i=0;
        String lt[]=d.list();
        while(i<lt.length){
            System.out.println(lt[i]);
            i++;
       }
   }
    public static void main(String args[]){
        File f=new File("D:/java/2007-2Java/code/ch08","file1.txt");
        File d=new File("D:/java/2007-2Java/code/ch08/data2");
        File d1=new File("D:/java/2007-2Java/code/ch08/data2/data3");
        File_ex fe=new File_ex();
        fe.FileInformation(f);
        fe.DirectoryInformation(d);
        d1.mkdir();
     }
  }
