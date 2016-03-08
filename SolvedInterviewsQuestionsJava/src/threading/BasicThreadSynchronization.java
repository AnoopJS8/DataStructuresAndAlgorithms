package threading;

import java.util.Scanner;

class Processor extends Thread{

	//private boolean running=true;
	private volatile boolean running=true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		while(running){
			System.out.println("Hello Anoop!!!");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void shutdown(){
		running=false;
		
	}
	
}

public class BasicThreadSynchronization {
	public static void main(String[] args) {
		Processor processor=new Processor();
		processor.start();//When we call the start it spawns a different thread apart from the main thread.
		
		System.out.println("Please enter to Stop");
		Scanner sc=new Scanner(System.in);
		sc.nextLine();
		
		processor.shutdown();
		
	}

}
