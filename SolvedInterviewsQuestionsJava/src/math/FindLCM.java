package math;

public class FindLCM {

	public static int LCM(int x,int y){
		int lcm=Math.max(x, y);
		int i=2;
		int temp=lcm;
		while(!(lcm%x==0 && lcm%y==0)){
			lcm=temp*i;
			//System.out.println(lcm);
			i++;
			
		}
		
		
		return lcm;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LCM(4, 6));

	}

}
