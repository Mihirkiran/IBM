import java.util.*;
import java.io.*;
import java.nio.file.Files;

class FileInformation{
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
        File file = new File(str); 

        boolean exists = file.exists(); 
        if(exists == true) {  
        	System.out.println("File Exists!!!");
            System.out.println("Readable: " + file.canRead()); 
            System.out.println("Writable: " + file.canWrite()); 
            System.out.println("File size: " + file.length());
            // System.out.println("File Type: " + getContentType(file));
        } 
        else{ 
            System.out.println("File not found."); 
        } 
    }
}