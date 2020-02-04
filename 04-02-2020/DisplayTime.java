// import java.util.Date;
// import java.text.DateFormat;
// import java.text.SimpleDateFormat;

class DisplayTime extends Thread{
	@Override
	public void run(){
		int n = 0;
		try{
			while(true){
				n++;
				Thread.sleep(1000);
				System.out.print("\b\b\b\b\b\b" + n);
			}
		}catch(InterruptedException ie){
			System.out.println("Thread Interrupted!!!");
		}
	}
	public static void main(String[] args) {
		DisplayTime dt = new DisplayTime();
		dt.start();
	}
}