package threading;

//2nd way to create a thread is to implement Runnable and pass it to the constructor of the Thread Class.

class Runner1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
		{
			System.out.println("Hello "+i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
public class StartThreadsAlternate {
	
	public static void main(String[] args) {
		Thread t1=new Thread(new Runner1());
		Thread t2=new Thread(new Runner1());
		
		t1.start();
		t2.start();
	}
}
