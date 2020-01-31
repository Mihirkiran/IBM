import java.util.Scanner;

class SumOfCubes{
	static int FindCube(int a){
		a = a * a * a;
		return (a);
	}
	public static void main(String[] args) {
		int n, sum = 0, m;
		System.out.println("Enter a number:");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		while(n != 0){
			sum = sum + FindCube(n % 10);
			n = n/10;
		}
		System.out.print(sum);
	}
}