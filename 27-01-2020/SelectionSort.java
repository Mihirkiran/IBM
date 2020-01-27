import java.util.Scanner;

class SelectionSort{
	public static void main(String args[]){
		int arr[] = new int[5];
		int i, j, temp, min;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the numbers of the array:");
		for(i = 0; i < 5; i++){
			arr[i] = sc.nextInt();
		}
		for(i = 0; i < 4; i++){
			min = i;
			for(j = i + 1; j < 5; j++){
				if(arr[min] > arr[j])
					min = j;
			}
			if(min == i){
				continue;
			}
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		System.out.println("The sorted array is:");
		for(i = 0; i < 5; i++){
			System.out.print(arr[i]);
		}
	}
}