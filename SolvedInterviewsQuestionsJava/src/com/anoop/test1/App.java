package com.anoop.test1;



class Machine{
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		return "toSring";
	}
}
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Machine m1=new Machine();
		System.out.println(m1);//.toString();
		
	}

}
