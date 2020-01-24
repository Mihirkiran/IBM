class Tables{
	public static void main(String args[]){
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		for(int i = 0; i < b; i++){
			System.out.println(a + " * " + i + " = " + (a*i));
		}
	}
}