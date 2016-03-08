package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hey ,Please Enter a Sentence");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String output = reverseWords(input);
		System.out.println(output);
		sc.close();

	}

	public static String reverseWords(String sentence) {
		StringBuilder sb = new StringBuilder();
		// List<String> list=new ArrayList<String>();
		String[] lists = sentence.split("\\s");
		for (int i = lists.length - 1; i >= 0; i--) {
			sb.append(lists[i]).append(" ");
		}
		return sb.toString().trim();

	}

	public static String reverseString(String line) {
		if (line.trim().isEmpty()) {
			return line;
		}
		StringBuilder reverse = new StringBuilder();
		String[] sa = line.trim().split("\\s");
		for (int i = sa.length - 1; i >= 0; i--) {
			reverse.append(sa[i]);
			reverse.append(' ');
		}
		return reverse.toString().trim();
	}

	/* * Method to reverse words in String in Java */ 
	public static String reverseWordss(String sentence) {
		List<String> words = Arrays.asList(sentence.split("\\s"));
		Collections.reverse(words);
		StringBuilder sb = new StringBuilder(sentence.length());
		for (int i = words.size() - 1; i >= 0; i--) {
			sb.append(words.get(i));
			sb.append(' ');
		}
		return sb.toString().trim();
	}

	//Read more:http:// java67.blogspot.com/2015/06/how-to-reverse-words-in-string-java.html#ixzz3rLWtBuEM
}
// Read more:http://
// java67.blogspot.com/2015/06/how-to-reverse-words-in-string-java.html#ixzz3rLWtBuEM