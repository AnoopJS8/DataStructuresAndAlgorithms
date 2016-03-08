package strings;

public class combinationString {

	
	public static void printCombinations(String input,int start,StringBuilder sb){
		for(int i=start;i<input.length();i++){
			sb.append(input.charAt(i));
			System.out.println(sb);
			if(i<input.length()){
				printCombinations(input, i+1, sb);
			}
			sb.setLength(sb.length()-1);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printCombinations("wxyz", 0, new StringBuilder());

	}

}
