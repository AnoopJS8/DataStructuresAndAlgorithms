package dynamicProgramming;
/*
 * 1) Optimal Substructure:
 *	Let X[0..n-1] be the input sequence of length n and L(0, n-1) be the length of the longest palindromic 
 *  subsequence of X[0..n-1].
 *  If last and first characters of X are same, then L(0, n-1) = L(1, n-2) + 2(b/c we are adding two characters,
 *   so length will increase by 2).
 *  Else L(0, n-1) = MAX (L(1, n-1), L(0, n-2)). 
 *  
 * */

public class LongestPalindromicSubSequence {

	public int calculateDP(char[] str) {
		int T[][] = new int[str.length][str.length];
		// Populating the subsequence of length 1. i.e indexes pointing to each
		// chars.
		for (int i = 0; i < str.length; i++) {
			T[i][i] = 1;
		}
		for (int len = 2; len <= str.length; len++) {
			for (int i = 0; i < str.length - len + 1; i++) {
				int j = i + len - 1;

				if (len == 2 && str[i] == str[j]) {
					T[i][j] = 2;
				} else if (str[i] == str[j]) {
					T[i][j] = T[i + 1][j - 1] + 2;
				} else {
					T[i][j] = Math.max(T[i][j - 1], T[i + 1][j]);
				}
			}
		}
		return T[0][str.length-1];
	}
	
	public int calculateRecursive(char str[],int start,int len){
        if(len == 1){
            return 1;
        }
        if(len ==0){
            return 0;
        }
        if(str[start] == str[start+len-1]){
            return 2 + calculateRecursive(str,start+1,len-2);
        }else{
            return Math.max(calculateRecursive(str, start+1, len-1), calculateRecursive(str, start, len-1));
        }
    }
	
	public static void main(String args[]){
        LongestPalindromicSubSequence lps = new LongestPalindromicSubSequence();
        String str = "agbdba";
        int r1 = lps.calculateRecursive(str.toCharArray(), 0, str.length());
        int r2 = lps.calculateDP(str.toCharArray());
        System.out.print(r1 + " " + r2);
    }
}
