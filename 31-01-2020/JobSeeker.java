import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class JobSeeker{
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter the Username:");
		String line = sc.nextLine();
      	String pattern = ".{8,}_job";
      	Pattern r = Pattern.compile(pattern);
      	Matcher m = r.matcher(line);
      	if (m.find()){
      		System.out.println("True");
      	}
      	else{
      		System.out.print("False");
      	}
	}
}