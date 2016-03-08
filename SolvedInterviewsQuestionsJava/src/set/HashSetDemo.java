package set;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
	
	public static Set<String> setHash=new HashSet<String>();
	
	public static void main(String[] args) {
		setHash.add(new String("Anoop"));
		setHash.add(new String("Sahoo"));
		setHash.add(new String("Anoop"));
		setHash.add("Anoop");
		
		System.out.println(setHash);
		
		
	}

}
