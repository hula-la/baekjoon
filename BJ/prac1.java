package BJ;

import java.util.Scanner;


public class prac1 {
	public static void main(String[] args) {
		long x1=1000000000,x2=-1000000000;
		long y1=1000000000,y2=-1000000000;
		long a = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
        long b = (long) Math.pow(x1-x2,2)+ (long) Math.pow(y1-y2,2);
        System.out.println(a);
        System.out.println(b);
	}
}
