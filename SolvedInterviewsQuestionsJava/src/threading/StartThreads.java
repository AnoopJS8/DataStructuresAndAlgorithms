package threading;

class Runner extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
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

public class StartThreads {
	public static void main(String[] args) {
		Runner runner1=new Runner();
		runner1.start();//If run is called it will run in the main thread.
		
		Runner runner2=new Runner();
		runner2.start();
	}
}
