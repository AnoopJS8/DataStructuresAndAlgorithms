package trie;

import java.util.Scanner;

class TrieNode {
	String name;
	TrieNode[] children;

	public TrieNode() {
		children = new TrieNode[26];
		for (int i = 0; i < 26; i++) {
			children[i] = null;
		}
	}
}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void add(String word) {
		TrieNode[] children = root.children;
		for (int i = 0; i < word.length(); i++) {
			char c = word.toLowerCase().charAt(i);

			TrieNode trav;
			if (children[c - 'a'] != null) {
				trav = children[c - 'a'];
			} else {
				trav = new TrieNode();
				children[c - 'a'] = trav;
			}
			children = trav.children;

			if (i == word.length() - 1) {
				trav.name = word;
			}
		}
	}

	public String find(String partial) {
		TrieNode[] children = root.children;
		TrieNode trav = null;
		for (int i = 0; i < partial.length(); i++) {
			char c = partial.toLowerCase().charAt(i);
			if (children[c - 'a'] != null) {
				trav = children[c - 'a'];
				children = trav.children;
			} else {
				return null;
			}
		}
		//int count = 1;

		return trav.name;
	}

}

public class TrieImplementation {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		Trie trie = new Trie();
		for (int t = 0; t < T; t++) {
			// System.out.println(sc.nextLine());
			String[] strInput = sc.nextLine().split("\\s");
			if (strInput[0].equals("add")) {
				trie.add(strInput[1]);// System.out.println("Addition");
			} else {
				System.out.println(trie.find(strInput[1]));
			}
		}
	}

}
