class Area{
	public int area(int l, int b);
}
class Rec extends Area{
	@Override
	int area(int l, int b){
		return (l * b);
	}
}
class Tri extends Area{
	@Override
	int area(int l ,int b){
		return (l * b);
	}
}