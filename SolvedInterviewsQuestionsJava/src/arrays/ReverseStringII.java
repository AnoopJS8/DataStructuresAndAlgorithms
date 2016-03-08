package arrays;

/*Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
*/		

public class ReverseStringII {
	
	public static void reverseWords(char[] s){
		if(s.length==0)
			return;
		reverse(s,0,s.length-1);
		int last=0;
		for(int  i=0;i<s.length;i++){
			if(s[i]==' '){
				reverse(s,last,i-1);
				last=i+1;
			}
		}
		reverse(s,last,s.length-1);
		
	}
	
	public static void reverse(char[] arr,int start,int end){
		while(start<end){
			char temp;
			temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
			
		}
		
	}
	public static void main(String[] args) {
		String str="the sky is blue";
		char[] carr=str.toCharArray();
		reverseWords(carr);
		for(char c:carr){
			System.out.print(c);
		}
	}
	
}
