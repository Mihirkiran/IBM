import java.util.Scanner;

class MyException extends Exception{
	void printMessage(){
		System.out.print("Age below limit!!!");
	}
}
class ValidateAge{
	public static void main(String[] args) {
		System.out.println("Enter the age: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		try{
			if(n <= 15){
				throw new MyException();
			}
		}
		catch(MyException me){
			me.printMessage();
		}
	}
}