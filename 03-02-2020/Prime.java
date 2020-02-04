import java.util.Scanner;

class Prime{
	static boolean checkPrime(int n){
		for(int i = 2; i < n; i++){
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println("Enter the number: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i < n; i++){
			if(checkPrime(i) == true){
				System.out.println(i);
			}
		}
	}
}