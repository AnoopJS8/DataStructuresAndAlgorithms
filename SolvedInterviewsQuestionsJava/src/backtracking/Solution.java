package backtracking;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void numberPerm(List<String> list,String str,int startIdx,int lastIdx){
        if(startIdx==lastIdx){
            StringBuilder sb=new StringBuilder();
            for(int k=0;k<lastIdx;k++){
                sb.append(str.charAt(k));
            }
            list.add(sb.toString());
        }else{
        	char[] carr=str.toCharArray();
            for (int i = startIdx; i < lastIdx; i++) {
				char t = carr[startIdx];
				carr[startIdx] = carr[i];
				carr[i] = t;
				numberPerm(list, str, startIdx + 1, lastIdx);
				t = carr[startIdx];
				carr[startIdx] = carr[i];
				carr[i] = t;// recover the old array again or backtrack
			}
        }
        
        
    }
    public static int checkGreater(String str,String test){
		
    	
    	return test.compareTo(str);
    	
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();sc.nextLine();
        while(t-->0){            
            String test=sc.nextLine();
            System.out.println(test);
            List<String> list=new ArrayList<String>();
            numberPerm(list,test,0,test.length());
            for(int i=0;i<list.size();i++){
                if(checkGreater(list.get(i),test)==1){
                    System.out.println(list.get(i));
                    break;
                }   
            }
        }
    }
    
}