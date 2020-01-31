import java.io.*;
import java.util.*;
class Simple{
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner objScanner = new Scanner(System.in);
		System.out.print("\nEnter A Line Of Integers:");
		String line = objScanner.nextLine();
		StringTokenizer st = new StringTokenizer(line);
        System.out.println("\nNumber of tokens: " + st.countTokens());
		long sum = 0;
		System.out.print("\nTokens are:\n");
		while (st.hasMoreTokens()){
            long i = Long.parseLong(st.nextToken());
			System.out.print(i + "\n");
			sum = sum + i;
		}
		System.out.println("\nThe Sum Is:" + sum);
	}
}