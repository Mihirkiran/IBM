import java.util.Scanner;

class SumOfNaturalNumbers{
	static int calculateSum(int n){
		int sum = 0;
		for(int i = 1; i <= n; i++){
			if(i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		return sum;
	}
	public static void main(String[] args) {
		int n;
		System.out.println("Enter n value:");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.print(calculateSum(n));
	}
}