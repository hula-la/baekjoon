package BJ;

import java.util.Scanner;
import java.util.Stack;

public class BJ1918 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] exp = sc.nextLine().toCharArray();
		Stack<Character> que = new Stack<Character>();
		Stack<Character> oper = new Stack<Character>();

		
		for(int i=0;i<exp.length;i++) {
			char c = exp[i];
			
			if (c==')') {
				while (oper.peek()!='(') {
					que.add(oper.pop());
				}
				oper.pop();
			} 
			else if (c=='(') {
				oper.add(c);
			}
			else if (c=='+'||c=='-') {
				while (!oper.empty()&&oper.peek()!='(') {
					que.add(oper.pop());
				}
				oper.add(c);
			}
			else if (c=='*'||c=='/') {
				while (!oper.empty()&&oper.peek()!='('&&oper.peek()!='+'&&oper.peek()!='-') {
					que.add(oper.pop());
				}
				oper.add(c);
			}
			else {
				que.add(c);
			}
		}
		while(!oper.empty()) {
			que.add(oper.pop());
		}
		
		for(char i:que) {
			System.out.print(i);
		}
	}
}
