import java.util.Scanner;

class TrafficLight{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n1. RED\n2. YELLOW\n3. GREEN\n");
		System.out.println("Enter the option");
		int n = sc.nextInt();
		switch(n){
			case 1:
				System.out.println("STOP");
				break;
			case 2:
				System.out.println("READY");
				break;
			case 3:
				System.out.println("GO");
				break;
			default:
				System.out.println("Enter the correct option!!!!");
		}

	}
}