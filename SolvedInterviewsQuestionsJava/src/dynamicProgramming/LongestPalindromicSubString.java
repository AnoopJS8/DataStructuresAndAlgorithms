package dynamicProgramming;

public class LongestPalindromicSubString {
	
	public static String longestPalindromicSubString(String str){
		if(str==null)
			return null;
		if(str.length()==1)
			return str;
		int maxLen=0;
		String longestStr=null;
		int len=str.length();
		int[][] T=new int[len][len];
		
		//since all the substrings of length 1 are palindromes.
		for(int i=0;i<len;i++){
			T[i][i]=1;
		}
		
		//check for substring of length 2.//Two consecutive same letters are palindrome.
		for(int i=0;i<len-2+1;i++){
			if(str.charAt(i)==str.charAt(i+1)){
				T[i][i+1]=1;
				maxLen=2;
				longestStr=str.substring(i, i+2);
			}
		}
		//System.out.println("here-> "+longestStr);
		// Check for lengths greater than 2. l is length
	    // of substring
		for(int l=3;l<=len;l++){
			for(int i=0;i<len-l+1;i++){
				int j=l+i-1;
				if(str.charAt(i)==str.charAt(j) && T[i+1][j-1]==1){
					T[i][j]=1;
					if(l>maxLen){
						maxLen=l;
						longestStr=str.substring(i, j+1);
						//System.out.println("here2-> "+longestStr+" "+maxLen);
					}
				}else{
					T[i][j]=0;
				}
			}
		}
		//System.out.println("here3");
		return longestStr;
	}
	
	public static void main(String[] args) {
		String str="abbcbaa";
		String pal=longestPalindromicSubString(str);
		System.out.println(pal);
	}
}
