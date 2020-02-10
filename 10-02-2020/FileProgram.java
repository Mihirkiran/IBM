import java.util.*;
import java.io.*;

class CopyDataThread extends Thread{
	public void run() {
		try{
			int count = 0, i;
			String str = "";
			File file1 = new File("source.txt");
			File file2 = new File("target.txt");
			FileReader fr = new FileReader(file1);
			FileWriter fw = new FileWriter(file2, true);
			while(( i = fr.read()) != -1){
				count++;
				str = str + (char)i;
				if(count % 10 == 0){
					fw.write((char)i);
					System.out.println("10 characters are copied!!!");
					Thread.sleep(5000);
					str = "";
				}
			}
		} 
		catch(IOException io){
			System.out.println("Error!!!");
		}
		catch(InterruptedException ie){
			System.out.println("Error!!!");
		}
	}
}

class FileProgram{
	public static void main(String[] args) {
		CopyDataThread c = new CopyDataThread();
		c.start();
	}
}