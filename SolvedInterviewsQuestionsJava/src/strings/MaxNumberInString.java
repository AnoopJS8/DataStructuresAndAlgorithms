package strings;

//Question : FInding the maximum integer present in the string

public class MaxNumberInString {
	
	public static Integer returnMaximumNumber(String str){
		int max=0;
		int temp=0;
		for(int i=0;i<str.length();i++){
			if(!(str.charAt(i)>=48 && str.charAt(i)<58)){
				//max=temp;
				if(max<temp){
					max=temp;
					//temp=0;
				}
				//max=temp;
				temp=0;
			}else{
				temp=10*temp+(str.charAt(i)-'0');
				//System.out.println("*"+temp);
			}
		}
		
		
		return max>temp?max:temp;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(returnMaximumNumber("A56bdn89"));
		System.out.println(returnMaximumNumber("A56bd1009n89"));
		System.out.println(returnMaximumNumber("A56bdn89bx"));
		System.out.println(returnMaximumNumber("A516b23"));
	}

}
