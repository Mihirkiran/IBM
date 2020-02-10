import java.util.*;
import java.io.*;

class ReplaceWord{
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		File f = new File("MyFile.txt");

		BufferedReader br = new BufferedReader(new FileReader(f));
		String str = "", s = "";
		while((str = br.readLine()) != null){
		    s += str;
		    s += "\n";
		}
		String fixedInput = s.replaceAll(str1, "ABCXYZ");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		bw.write(fixedInput);
		bw.flush();
		br.close();
	}
}