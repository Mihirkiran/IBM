import java.util.*;
import java.io.*;

class DisplayCount{
	public static void main(String[] args) throws IOException{
		int characters = 0, words = 0, lines = 0;
		File f = new File("MyFile.txt");

		BufferedReader br = new BufferedReader(new FileReader(f));
		StringBuilder sb = new StringBuilder("");

		String str = "", s = "";
		while((str = br.readLine()) != null){
		    // sb.append(str + "\n");
		    s += str;
		    lines++;
		    words++;
		}
		words = words + s.split(" ").length - 1;
		characters = s.length();
		br.close();
		System.out.println(characters);
		System.out.println(words);
		System.out.println(lines);
	}
}