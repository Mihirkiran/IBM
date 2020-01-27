class CalculateByUsingMethodsParamsReturn{
    public static void main(String[] args) {
        new CalculateByUsingMethodsParamsReturn().getInput();
    }

    void getInput(){
        int firstNum, secondNum;
 
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("Enter two numbers");
 
        firstNum = scan.nextInt();
        secondNum = scan.nextInt();
        new CalculateByUsingMethodsParamsReturn().printResult(firstNum, secondNum);
    }

    void printResult(int firstNum, int secondNum){
        System.out.println("Addition of no's is : " + new CalculateByUsingMethodsParamsReturn().add(firstNum, secondNum));
    }

    int add(int firstNum, int secondNum){
        return (firstNum + secondNum);
    }
}
 
 
//   Message/s
// a--------->b
// <---------
 
//   Message/s(0-n)
// a--------->b
// <---------
//  Message(0-1)