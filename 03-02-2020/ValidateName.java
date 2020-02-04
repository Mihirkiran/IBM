import java.util.*;

class MyException extends Exception{
	void printMessage(){
		System.out.println("Enter First Name or Last Name!!!");
	}
}

class ValidateName{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name: ");
		String firstname = sc.nextLine();
		System.out.println("Enter Last Name: ");
		String lastname = sc.nextLine();
		try{
			if(firstname.equals("") || lastname.equals("")){
				throw new MyException();
			}
		}
		catch(MyException me){
			me.printMessage();
		}
	}
}