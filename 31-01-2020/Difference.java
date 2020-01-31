import java.util.Scanner;

class Difference{
	static int square(int a){
		return (a * a);
	}
	static int calculateDifference(int n){
		int sum1 = 0, sum2 = 0;
		for(int i = 1; i <= n; i++){
			sum1 = sum1 + i;
		}
		sum1 = sum1 * sum1;
		for(int j = 1; j <= n; j++ ){
			sum2 = sum2 + (j * j);
		}
		sum2 = sum2 - sum1;
		return sum2;

	}
	public static void main(String[] args) {
		int n;
		System.out.println("Enter a number:");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.print(calculateDifference(n));
	}
}