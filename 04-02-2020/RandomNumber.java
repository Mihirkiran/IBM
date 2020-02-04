import java.util.Random;

class RandomNumber extends Thread{
	@Override
	public void run(){
		try{
			while(true){
				Random r = new Random();
				int n = r.nextInt(10000);
				System.out.println(n);
				n++;
				Thread.sleep(1000);
			}
		}catch(InterruptedException ie){
			System.out.println("Thread Interrupted!!!");
		}
	}
	public static void main(String[] args) {
		RandomNumber r = new RandomNumber();
		r.start();
	}
}