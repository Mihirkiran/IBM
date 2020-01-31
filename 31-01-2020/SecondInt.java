import java.util.*;

class SecondInt{

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int num = input.nextInt();
    int array[] = new int[num];
        for (int i = 0 ; i < array.length; i++ ) {
           array[i] = input.nextInt();
        }
    Arrays.sort(array);
    System.out.println(array[1]);
	}
}