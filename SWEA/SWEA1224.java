package SWEA;


import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class SWEA1224 {
	static char[] OPER = {'*','+','(',')'}; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
 		
		for(int i=1;i<tc+1;i++) {
			int N = Integer.parseInt(sc.nextLine());
			String ntAll = sc.nextLine();
			Deque<Object> exp = new LinkedList<>();
			Stack<Object> stack = new Stack<>();

			
			for (int j=0;j<N;j++) {
				char nt = ntAll.charAt(j);
				
				if (!isOper(nt)) {
					exp.add(nt-'0');
				}
				else {
					if (nt=='(') {
						stack.add('(');
					}
					else if (nt==')') {
						while(!stack.peek().equals('(')) {
							exp.add(stack.pop());
						}
						stack.pop();
					}
					else if (nt=='+') {
						while((!stack.isEmpty())&&!stack.peek().equals('(')) {
							exp.add(stack.pop());
						}
						stack.add(nt);
					}
					else {
						while(((!stack.isEmpty())&&!stack.peek().equals('('))&&((stack.peek()=="*"))) {
							exp.add(stack.pop());
						}
						
						
						stack.add(nt);
					}
					
				}
			
			}
			while(!stack.isEmpty()) {
				exp.add(stack.pop());
			}
			
			System.out.print("#"+i+" "+calculate(exp)+"\n");
			
		}
	}
	public static int calculate(Deque que) {
		Stack<Integer> stack = new Stack<Integer>();
		
		while(!que.isEmpty()) {
			Object fo = que.poll();
			
			if (fo instanceof Integer) {
				stack.add((int) fo);
			}
			else {
				int b = stack.pop();
				int a = stack.pop();
				
				switch((char)fo) {
				case('+'):stack.add(a+b);break;
				case('-'):stack.add(a-b);break;
				case('/'):stack.add(a/b);break;
				case('*'):stack.add(a*b);break;
				}
			}
			
		}

		return stack.peek();
	}
	
	
	public static boolean isOper(char i) {
		for(char c:OPER) {
			if(c==i) return true;
		}
		return false;
	}
}
