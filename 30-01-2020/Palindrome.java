import java.util.Scanner;

class Palindrome{
	public static void main(String[] args) {
		StringBuffer str;
		String a;
		Scanner sc = new Scanner(System.in);
		a = sc.nextLine();
		str = new StringBuffer(a);
		if(a.equals(str.reverse().toString())){
			System.out.println("Palindrome");
		}
		else{
			System.out.println("Not a Palindrome");
		}
	}
}