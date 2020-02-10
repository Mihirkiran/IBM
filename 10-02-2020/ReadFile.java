import java.util.*;
import java.io.*;

class ReadFile{
	public static void main(String[] args) throws IOException {
		int n = 1;
		File f = new File("MyFile.txt");

		BufferedReader br = new BufferedReader(new FileReader(f));
		String str = "";
		while((str = br.readLine()) != null){
		    System.out.println(n + " " + str);
		    n++;
		}
		br.close();
	}
}