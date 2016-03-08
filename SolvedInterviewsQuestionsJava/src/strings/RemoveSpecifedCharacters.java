package strings;

import java.util.ArrayList;
import java.util.List;

public class RemoveSpecifedCharacters {
	
	public static String removeChars(String str,String remove){
		List<Character> rem=new ArrayList<Character>();
		for(int i=0;i<remove.length();i++){
			rem.add(remove.charAt(i));
		}
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length();i++){
			if(!rem.contains(str.charAt(i))){
				sb.append(str.charAt(i));
			}
		}
		
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String str="Battle of vowels";
		String remove="aeiou";
		System.out.println(removeChars(str, remove));
		
	}
}
