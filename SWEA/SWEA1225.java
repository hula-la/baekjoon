package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int a = 0; a<10; a++) {
			Queue<Integer> arr = new LinkedList<Integer>();
			
			int N = sc.nextInt();
			
			for(int i = 0;i<8;i++) {
				arr.add(sc.nextInt());
			}
			cycle: while(true) {
				for(int i = 1;i<=5;i++) {
					int diff = arr.poll()-i;
					
					if (diff<=0) {
						arr.add(0);
						break cycle;
					}
					arr.add(diff);
				}
			}
			System.out.print("#"+N);
			arr.forEach(i->System.out.print(" "+i));
			System.out.println();
		}
	}

}
