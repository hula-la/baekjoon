package BJ;

import java.util.List;;
import java.util.LinkedList;
import java.util.Scanner;

public class testC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.next().toCharArray();
		List<Integer[]> dpL = new LinkedList<>();
		
		int cntS = 0;
		int cntK = 0;
		
		for (int i = 0; i < s.length; i++) {
			if(s[i]=='S') {
				cntS++;
				dpL.add(new Integer[] {i,1,0});
			}
			if(s[i]=='K') {
				cntK++;
				dpL.add(new Integer[] {i,0,1});
			}
		}
		
		
	}
}
