package bj;

import java.util.Scanner;

public class bj2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] nums = sc.nextLine().split(" ");
		int a = Integer.parseInt(nums[0]);
		int b = Integer.parseInt(nums[1]);
		int n1,n2,tmp;
		
		if(a>b) {
			n1 = a;
			n2 = b;
		}
		else {
			n1 = b;
			n2 = a;
		}
		
		while(true) {
			tmp = n2;
			n2 = n1%n2;
			n1 = tmp;
			
			if (n2==0) {
				System.out.println(n1);
				System.out.println(a*b/n1);
				break;
			}
		}
	}
}
