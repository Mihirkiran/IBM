class ChangeValue{
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("I love C++");
		str.replace(0, str.length(), "I love Java");
		System.out.print(str);
	}
}