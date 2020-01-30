import java.util.Scanner;

class FindChar{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter character to be found: ");
		String s = sc.nextLine();
		String str = "I love Java";
		char c = s.charAt(0);
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == c){
				System.out.print("Found");
				flag = true; 
			}
		}
		if(flag == false){
			System.out.print("Not Found!!!");
		}
	}
}