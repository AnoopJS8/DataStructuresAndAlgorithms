package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/*
 * LCS[i...j]=longest common subsequence in X[1..i] & Y[1..j]
 * LCS[i...j]= 0 if i==0||j==0
 * 			 = LCS[i-1,j-1]+1 ,if X[i]==Y[j]
 * 			 =Max(LCS[i-1,j],LCS[i,j-1]),if X[i]!=Y[j]
 * 
 * */

public class LongestCommonSubSequence {
	
	public static int lcsDynamic(char str1[],char str2[]){
		int T[][]=new int[str1.length+1][str2.length+1];
		int max=0;
		int mi=0,mj=0;
		//StringBuilder sb=new StringBuilder();
		List<Character> seq=new ArrayList<Character>();
		for(int i=1;i<T.length;i++){
			for(int j=1;j<T[i].length;j++){
				if(str1[i-1]==str2[j-1]){
					T[i][j]=T[i-1][j-1]+1;
					//sb.append(str1[i-1]);
				}else{
					T[i][j]=Math.max(T[i-1][j], T[i][j-1]);
				}
				if(T[i][j]>max){
					max=T[i][j];
					mi=i;mj=j;
				}
			}
		}
		/*Print Table
		for(int i=0;i<T.length;i++){
			for(int j=0;j<T[i].length;j++){
				System.out.print(T[i][j]+" ");
			}System.out.println();
		}*/
		
		//System.out.println(mi+","+mj);
/*		while(mi>0&&mj>0){   //while(mi>=0&&mj>=0){
			//seq.add(0, T[mi][mj]);
			//seq.add(0, str1[mi]);
			if(T[mi][mj]==(T[mi-1][mj-1]+1)){
				seq.add(0, str1[mi-1]);//||mi-1;
				//seq.add(0, str2[mj-1]);
				System.out.println(T[mi][mj]);
				mi=mi-1;mj=mj-1;
			}else if (T[mi-1][mj]==T[mi][mj]){
				mi=mi-1;System.out.println(T[mi][mj]);
			}else if(T[mi][mj-1]==T[mi][mj]){
				mj=mj-1;System.out.println("last cond"+T[mi][mj]);
			}
		}*/
		
		while(mi>0&&mj>0){   //while(mi>=0&&mj>=0){
			//seq.add(0, T[mi][mj]);
			//seq.add(0, str1[mi]);
			if (T[mi-1][mj]==T[mi][mj]){
				mi=mi-1;///System.out.println(T[mi][mj]);
			}else if(T[mi][mj-1]==T[mi][mj]){
				mj=mj-1;///System.out.println("last cond"+T[mi][mj]);
			}else if(T[mi][mj]==(T[mi-1][mj-1]+1)){
				seq.add(0, str1[mi-1]);//||mi-1;
				//seq.add(0, str2[mj-1]);
				////System.out.println(T[mi][mj]);
				mi=mi-1;mj=mj-1;
			}
		}
		
		
		System.out.println(seq);
		//System.out.println(sb.toString());
		return max;
	}
	
	public static void main(String[] args) {
		//int t[][]=new int[5][10];
		//System.out.println(t.length);
		
		String str1 = "ABCDAF";
        String str2 = "ACBCF";
        
       // String str1 = "ABCB";
        //String str2 = "BDCAB";
        
        System.out.println(lcsDynamic(str1.toCharArray(), str2.toCharArray()));
		
	}
	
}
