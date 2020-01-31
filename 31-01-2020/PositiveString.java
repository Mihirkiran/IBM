import java.util.Scanner;

class PositiveString{
	static boolean checkPositiveString(String str){
		boolean flag = true;
		for(int i = 0; i < str.length() - 1; i++){
			if(str.charAt(i) > str.charAt(i + 1)){
				flag = false;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		String str;
		System.out.print("Enter the String: ");
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		boolean f = checkPositiveString(str);
		if(f == true){
			System.out.print("Positive String");
		}
		else{
			System.out.print("Not a Positive String");
		}
	}
}