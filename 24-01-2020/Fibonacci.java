class Fibonacci{
	public static void main(String[] args){
		int a = 1, b = 1, c;
		System.out.println(a);
		while(b <= 89){
			System.out.println(b);
			c = a + b;
			a = b;
			b = c;
		}
	}
}