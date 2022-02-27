package BJ;

import java.util.Scanner;

public class BJ1074 {
	public static void main(String[] args) {
		int result = 0;
		Scanner sc = new Scanner(System.in);
		
		sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int i=0;
		while(r!=0 || c!=0){
			result+=r%2*2*Math.pow(2, i*2) + c%2*Math.pow(2, i*2);
			r/=2; c/=2; i++;
		}
		
		System.out.println(result);
		sc.close();
	}
}
