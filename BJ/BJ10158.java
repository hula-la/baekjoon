package BJ;

import java.util.Scanner;

public class BJ10158 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int W,H,p,q,t,x,y;
		W=s.nextInt();
		H=s.nextInt();
		p=s.nextInt();
		q=s.nextInt();
		t=s.nextInt();
		x=(p+t)/W%2==0?(p+t)%W:W-(p+t)%W;
		y=(q+t)/H%2==0?(q+t)%H:H-(q+t)%H;
		System.out.print(x+" "+y);
	}
}