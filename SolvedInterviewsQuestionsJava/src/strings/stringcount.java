package strings;

import java.util.Scanner;

public class stringcount {
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String string=sc.nextLine();
		//System.out.println(string);
		int[] count=new int[26];
		
		for(int i=0;i<string.length();i++)
		{
			char c=string.toLowerCase().charAt(i);
			++count[c-'a'];
			
		}
		//int j=0;
		for(int i=0;i<string.length();i++)
		{
			//System.out.println("1: "+i);
			if(count[string.charAt(i)-'a']!=0){
				//System.out.println(count[i]);
				System.out.print(string.charAt(i)+""+count[string.charAt(i)-'a']);
				i=i+count[string.charAt(i)-'a']-1;
				//j=j+count[i];
				//System.out.println("2: "+i);
			}
		}
		
	}
}
