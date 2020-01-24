class MultipleIfs{
	public static void main(String args[]){
		int a, b, c, d;
		a = Integer.parseInt(args[0]);
		b = Integer.parseInt(args[1]);
		c = Integer.parseInt(args[2]);
		boolean flag = true;
		if(a < 40){
			flag = false;
		}
		if(b < 40){
			flag = false;
		}
		if(c < 40){
			flag = false;
		}
		if(a + b + c < 125){
			flag = false;
		}
		if(flag == true){
			System.out.print("PASSING");
		}
		if(flag == false){
			System.out.print("FAILING");
		}

	}
}