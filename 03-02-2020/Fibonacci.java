import java.util.Scanner;

class Fibonacci{
	static int first = 1;
	static int second = 1;
	public int findFibonacci(int n){
		if(n == 0)
			return second;
		int temp = second;
		second = second + first;
		first = second;
		n--;
		return findFibonacci(n);
	}
	public static void main(String[] args) {
		System.out.println("Enter the value of n: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		n = n - 2;
		//System.out.print(n);
		int m = new Fibonacci().findFibonacci(n);
		System.out.println(m);
	}
}