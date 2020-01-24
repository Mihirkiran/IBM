class Factorial{
	public static void main(String args[]){
		int fact = 1, var = Integer.parseInt(args[0]);
		for(int i=1;i<=var;i++){
			fact*=i;
		}
		System.out.print(fact);
	}
}