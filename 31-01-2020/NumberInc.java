import java.util.Scanner;

class NumberInc{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number");
		int number = sc.nextInt();
		System.out.println( increasing(number));
	}
	public static boolean increasing(int n){
 		int flag = 0;
 		while(n > 0){
 			int value1 = n%10;
 			n = n/10;
 			int value2 = n%10;
 			n = n/10;
			if(value1 > value2){
			 	flag = 1;
			}
			else{
			 	flag = 0;
			 	break;
			}
		}
		if(flag == 1){
			return true;
		}
		else{
		 	return false;
		}
	}
}