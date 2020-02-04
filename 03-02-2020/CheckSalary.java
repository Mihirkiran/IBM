import com.cg.eis.exception.EmployeeException;
import java.util.Scanner;

class CheckSalary{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Salary: ");
		int salary = sc.nextInt();
		try{
			if(salary < 3000){
				throw new EmployeeException();
			}
		}
		catch(EmployeeException ee){
			ee.PrintMessage();
		}
	}
}