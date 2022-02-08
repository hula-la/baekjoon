package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1228 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int a = 0; a<10; a++) {
			LinkedList<Integer> arr = new LinkedList<Integer>();
			Queue<Integer> arr2 = new LinkedList<Integer>();
			arr2.	
			
			int N = Integer.parseInt(br.readLine());
			
			int count = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");

			for(int i = 0;i<8;i++) {
				arr.offer(Integer.parseInt(st.nextToken()));
			}
			cycle: while(true) {
				for(int i = 1;i<=5;i++) {

					int diff = arr.removeFirst()-i;
					
					
					if (diff<=0) {
						arr.offer(0);
						break cycle;
					}
					else {
						arr.offer(diff);
					}
				}
				
			}
			System.out.print("#"+N);
			arr.forEach(i->System.out.print(" "+i));
			System.out.print("\n");
			
			
		}
	}

}
