import java.util.*;

class Employee{
	private String firstname, lastname = "";
	private int age;
	Employee(String firstname, String lastname, int age){
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}
	public String getFirstName(){
		return this.firstname;
	}
	public String getLastName(){
		return this.lastname;
	}
	public Integer getAge(){
		return this.age;
	}
	@Override
	public String toString(){
		return("Name: " + this.firstname + " " + this.lastname + " - " + age);
	}
}

class SortByAge implements Comparator{
	@Override
	public int compare(Object firstObj, Object secondObj){
		return((Employee)firstObj).getAge().compareTo(((Employee)secondObj).getAge());
	}
}

class SortByFirstName implements Comparator{
	@Override
	public int compare(Object firstObj, Object secondObj){
		return((Employee)firstObj).getFirstName().compareTo(((Employee)secondObj).getFirstName());
	}
}

class SortByLastName implements Comparator{
	@Override
	public int compare(Object firstObj, Object secondObj){
		return((Employee)firstObj).getLastName().compareTo(((Employee)secondObj).getLastName());
	}
}

class SortEmployee{
	public static void main(String[] args) {
		int option, age;
		String firstname, lastname = "", name;
		ArrayList<Employee> list = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("\n1. Add employee\n2. Sort by firstname\n3. Sort by lastname\n4. Sort by age\nEnter your option:");
			option = sc.nextInt();
			switch(option){
				case 1:
					System.out.println("Enter name:");
					name = sc.nextLine();
					name = sc.nextLine();
					String arr[] = name.split(" ");
					firstname = arr[0];
					if(arr.length > 1)
						lastname = arr[1];
					else
						lastname = "";
					System.out.println("Enter age:");
					age = sc.nextInt();
					System.out.println(arr[0]);
					list.add(new Employee(firstname, lastname, age));
					System.out.println("Employee added!!!");
					break;
				case 2:
					Collections.sort(list, new SortByFirstName());
					System.out.println(list);
					break;
				case 3:
					Collections.sort(list, new SortByLastName());
					System.out.println(list);
					break;
				case 4:
					Collections.sort(list, new SortByAge());
					System.out.println(list);
					break;
				default:
					System.out.println("Enter the correct option!!!");
			}
		}
	}
}