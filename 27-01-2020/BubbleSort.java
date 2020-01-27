import java.util.Scanner;

class BubbleSort{
	public static void main(String args[]){
		int arr[] = new int[5];
		int i, j, temp;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the numbers of the array:");
		for(i = 0; i < 5; i++){
			arr[i] = sc.nextInt();
		}
		for(i = 0; i < 4; i++){
			for(j = i; j < 4; j++){
				if(arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		System.out.println("The sorted array is:");
		for(i = 0; i < 5; i++){
			System.out.print(arr[i]);
		}
	}
}