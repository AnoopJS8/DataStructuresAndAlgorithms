package strings;

public class SubstringSearchMethods {

	public boolean naiveMethod(char[] text,char[] pattern){
		int i=0;
		int j=0;
		int k=0;
		while(i<text.length&&j<pattern.length){
			if(text[i]==pattern[j]){
				i++;
				j++;
			}else{
				j=0;
				k++;
				i=k;
			}
			
		}
		if(j==pattern.length){
			return true;
		}		
		
		return false;
	}
	
	//Building Prefix array for KMP pattern matching
	public int[] prefixArray(char[] pattern){
		int[] prefix=new int[pattern.length];
		int j=0;
		for(int i=1;i<pattern.length;){
			if(pattern[i]==pattern[j]){
				prefix[i]=j+1;
				i++;
				j++;
			}else{
				if(j!=0){
					j=prefix[j-1];
				}else{
					prefix[i]=0;
					i++;
				}
				
			}
		}
		return prefix;
		
	}
	
	//KMP ALgo
	
	public boolean KMP(char[] text,char[] pattern){
		int[] prefix=prefixArray(pattern);
		int i=0;int j=0;
		while(i<text.length&&j<pattern.length){
			if(text[i]==pattern[j]){
				i++;j++;
			}else{
				if(j!=0){
					j=prefix[j-1];
				}else{
					i++;
				}
				
			}
			
		}
		if(j==pattern.length)
			return true;
		
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "cvbnm";
        String subString = "bn";
        SubstringSearchMethods m = new SubstringSearchMethods();
        boolean result = m.KMP(str.toCharArray(), subString.toCharArray());
        System.out.print(result);

	}

}
