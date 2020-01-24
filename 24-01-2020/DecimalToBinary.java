class DecimalToBinary{
	public static void main(String args[]){
		int a = Integer.parseInt(args[0]);
		String str = "";
		while(a!=0){
			if(a % 2 == 1){
				str = "1" + str;
			}
			else{
				str = "0" + str;
			}
			a = a/2;
		}
		System.out.print(str);
	}
}