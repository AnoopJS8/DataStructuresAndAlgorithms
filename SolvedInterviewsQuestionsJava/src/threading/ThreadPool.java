package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ProcessorNew implements Runnable{

	private int id;
	public ProcessorNew(int id){
		this.id=id;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Starting : "+id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed : "+ id);
	}
		
}

public class ThreadPool {
	
	public static void main(String[] args) {
		
	
	//ExecutorService executor=new Executors.newFixedThreadPool(2);
	
	for(int i=0;i<5;i++)
	{
	//	executor.submit(new ProcessorNew(i));
	}
	
	//executor.shutdown();
	
	
	}
}
