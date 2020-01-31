import java.util.Scanner;

public class SortString{
    public static void main(String[] input){
        int i, j,temp1;
        String temp;
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        String names[] = new String[num];
        System.out.print("Enter the strings: ");
        for(i=0; i<num; i++){
            names[i] = scan.nextLine();
        }
        System.out.println("\nSorting the elements in order:\n");
        for(i=0; i<num; i++){
            for(j=1; j<num; j++){
                if(names[j-1].compareTo(names[j])>0){
                    temp=names[j-1];
                    names[j-1]=names[j];
                    names[j]=temp;
                }
            }
        }
        System.out.println("\nThe List after changing the case is:\n");
        for(i = 0 ;i < num; i++){
            System.out.println(names[i]);
        }
        if(num % 2 == 0){
           temp1 = num/2;
        }
        else{
            temp1 = num/2 + 1;
        }
        for( i = 0; i < temp1; i++){
            System.out.println(names[i].toUpperCase());
        }
        for(i = temp1; i < num; i++){
            System.out.println(names[i].toLowerCase());   
        }
    }
}