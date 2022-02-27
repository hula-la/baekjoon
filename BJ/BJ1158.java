package BJ;

import java.util.LinkedList;
import java.util.Scanner;

public class BJ1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		LinkedList<Integer> arr = new LinkedList<Integer>();

		int idx = 0;
		
		for (int i=1;i<=N;i++) {
			arr.add(i);
		}
		
		System.out.print("<");
		for (int i=N;i>1;i--) {
			idx = (idx + K-1)%i;
			System.out.print(arr.remove(idx)+", ");
		}
		System.out.print(arr.poll());
		System.out.print(">");

	}

}
