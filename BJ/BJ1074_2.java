package BJ;

import java.util.Scanner;

public class BJ1074_2 {
	public static void main(String[] args) {
		int a=0;
		Scanner s=new Scanner(System.in);
		s.next();
		int r=s.nextInt();
		int c=s.nextInt();
		int i=0;
		while(r!=0 || c!=0){
			a+=r%2*2*Math.pow(2,i*2)+c%2*Math.pow(2,i*2);
			r/=2;c/=2;i++;
		}
		System.out.print(a);
	}
}
