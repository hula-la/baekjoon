package ssafy.com.algo2;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class SW0207 {
	static Map<Character,Character> map = new HashMap();	

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		map.put('{','}');
		map.put('(', ')');
		map.put('[', ']');
		map.put('<', '>');
		
		testCase: for(int i=0; i<10;i++) {
			int len = sc.nextInt();
			String strArray = sc.next();
			Stack<Character> stack = new Stack<>();
			
			System.out.println(map.get('{'));
			
			for(int j = 0; j<len;j++) {
				char c = strArray.charAt(j);
				if (map.containsKey(c)){
					stack.push(strArray.charAt(j));
				} 
				else {
					if (map.get((stack.pop())) != c) {
						System.out.println("#"+(i+1)+" 0");
						continue testCase;
					}
				}
				
			}
			System.out.println("#"+(i+1)+" 1");
			
			
		}
		
	}
}
