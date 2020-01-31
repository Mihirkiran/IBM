import java.util.Scanner;

class PowerCheck{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number");
		int number = sc.nextInt();
		System.out.println( powerOfTwoGeneral(number));
	}

	public static boolean powerOfTwoGeneral(int n){
 		while(n%2==0){
 			n=n/2;
 		}
 		if(n==1){
 			return true;
 		}
 		else{
 			return false;
 		}
 	}
 }