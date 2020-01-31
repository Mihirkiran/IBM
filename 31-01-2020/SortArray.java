import java.util.*;

class SortArray{
	static String reverse(String str){
		String s = "";
		for(int i = (str.length() - 1); i >= 0; i--){
			s += str.charAt(i);
		}
		return s;
	}
	static int[] getSorted(int[] arr){
		String str;
		int a, b;
		for(int i = 0; i < arr.length; i++){
			b = arr[i];
			str = reverse(new Integer(b).toString());
			arr[i] = Integer.parseInt(str);
		}
		Arrays.sort(arr);
		return arr;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of integers");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the array of integers");
		for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		getSorted(arr);
		for(int i = 0; i < n; i++){
			System.out.print(arr[i]);
		}
	}
}