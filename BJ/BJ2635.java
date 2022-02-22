package bj;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ2635 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> tempArr = new ArrayList<Integer>();
		int result = 0;
		ArrayList<Integer> answerArr = new ArrayList<Integer>();
		
		
		for (int i=n;i>=n/2;i--) {
			tempArr.clear();
			int len = 1;
			tempArr.add(n);
			tempArr.add(i);

			while (tempArr.get(len-1)-tempArr.get(len)>=0) {
				tempArr.add(tempArr.get(len-1)-tempArr.get(len)); 
				len++;
			}
			
			if (len>result) {
				result = len;
				answerArr = (ArrayList<Integer>) tempArr.clone();
			}

			
		}
		System.out.println(result+1);
		for(int i=0;i<=result;i++) {
			System.out.print(answerArr.get(i)+" ");
		}
	}
}
