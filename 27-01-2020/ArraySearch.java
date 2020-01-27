import java.util.Scanner;

class ArraySearch{
	public static void main(String args[]){
		int arr[] = new int[10];
		int search, i;
		boolean flag = false; 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the numbers of the array:");
		for(i = 0; i < 10; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the number to be searched for:");
		search = sc.nextInt();
		for(i=0; i < 10; i++){
			if(arr[i] == search){
				System.out.println("Number found at index " + i);
				flag = true;
				break;
			}
		}
		if(flag == false){
			System.out.println("Number not found");
		}
	}
}