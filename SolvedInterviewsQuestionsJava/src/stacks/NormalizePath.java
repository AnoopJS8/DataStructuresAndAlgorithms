package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/*Problem:

Given an absolute path for a file (Unix-style), simplify it.
For example:
path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
Corner Cases: Did you consider the case where path = /../? In this case, you should return /. 
Another corner case is the path might contain multiple slashes / together, such as /home//foo/. 
In this case, you should ignore redundant slashes and return /home/foo.
*/
public class NormalizePath {
	
	public static String normalizePath(String path){
		Deque<String> stack=new ArrayDeque<String>();
		StringBuilder sb=new StringBuilder();
		String[] pathSplitter=path.split("/");
		for(String str:pathSplitter){
			if(str==null||str.equals(".")||str.length()==0){
				continue;
			}else if(str.equals("..")){
				if(!stack.isEmpty()){
					stack.removeLast();
				}
			}else{
				stack.addLast(str);
			}
		}
		if(stack.isEmpty()){
			return "/";
		}
		/*while(!stack.isEmpty()){
			
			sb.insert(0, stack.removeLast());
			sb.insert(0, "/");
			
		}*/ //This is not optimized as we have to shift element from the front to back for every insert operations
		while(!stack.isEmpty()){
			sb.append("/");
			sb.append(stack.removeFirst());
			
				
		}
		return sb.toString();
		//return null;
	}
	
	public static void main(String[] args) {
		String path="/home/../foo/";
		System.out.println(normalizePath(path));
	}

}
