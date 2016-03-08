package anonymousClassess;

class Machine{
	void start(){
		System.out.println("Machine Starting...");
	}
}
//Genrally to override the start function for any subclass we extend the parent class
//but in case of anonymous class we declare it just after the super class instantiation.

interface Plant{
	public void grow();
}

public class Anonymous {
	
	public static void main(String[] args) {
		
		Machine machine=new Machine();
		Machine machine1=new Machine(){
			@Override
			void start() {
				// TODO Auto-generated method stub
				//super.start();
				System.out.println("Camera Starting ...");
			}
			
		};
		machine.start();
		machine1.start();
		
		//Plant plant1=new Plant(); //This will throw an error as  Plant is an interface and we instantiate an interface.However,
		Plant plant1=new Plant(){
			@Override
			public void grow() {
				// TODO Auto-generated method stub
				System.out.println("Plant growing..");
			}
			
		};//So this is an anonymous class which implements the Interface having a reference of Interface Class. 
		plant1.grow();
	
	}
	
	
}
