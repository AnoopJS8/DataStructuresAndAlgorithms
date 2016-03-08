package strings;

//In Java Convert a string to signed Integer : Integer.parseInt()
//To convert integer to string :Integer.toString();
public class StringToInteger {
	
	public static int stringToInteger(String str){
		int num=0,idx=0;
		for(int i=0;i<str.length();i++){
		//for(int i=str.length()-1;i>=0;i--){
			char c=str.charAt(i);
			num=(num*10)+(c-'0');
			
		}
		
		return num;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringToInteger("0234"));
		
	}

}
