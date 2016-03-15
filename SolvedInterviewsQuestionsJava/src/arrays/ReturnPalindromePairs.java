package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Paiir{
	String str1;
	String str2;
	public Paiir(String s1,String s2){
		str1=s1;
		str2=s2;
	}
	@Override
	public String toString() {
		return "Paiir [str1=" + str1 + ", str2=" + str2 + "]";
	}
	
}
public class ReturnPalindromePairs {

	public static List<Paiir> returnAllPalindromePair(String[] input){
		List<Paiir> list=new ArrayList<>();
		Set<String> hashSet=new HashSet<>();
		for(String word:input){
			String rev=reverse(word);
			if(hashSet.contains(rev)){
				list.add(new Paiir(word,rev));
				hashSet.remove(rev);
			}else{
				hashSet.add(word);
			}				
			
		}
		
		
		return list;
	}
	public static String reverse(String str){
		StringBuilder sb=new StringBuilder();
		for(int i=str.length()-1;i>=0;i--){
			sb.append(str.charAt(i));
		}
		
		return sb.toString();
	}
	public static void main(String[] args) {
		String[] input={"anoop","jyoti","eye","lens","eye","one","none","exe","exe","zxz","zxz"};
		
		System.out.println(returnAllPalindromePair(input).size());
		
	}
	
}
