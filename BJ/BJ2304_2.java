package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2304_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer[]> arr = new LinkedList<Integer[]>();
		
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> l = new ArrayList<Integer>();
			l.add(Integer.parseInt(st.nextToken()));
			l.add(Integer.parseInt(st.nextToken()));
			Deque.
			
			if (l.get(1)>max[0]) {
				max[0] = l.get(1);
				max[1] = l.get(0);
				max[2] = l.get(0);
			}
			else if (l.get(1)==max[0]) {
				max[1] = Math.min(l.get(0), max[1]);
				max[2] = Math.max(l.get(0), max[2]);
			}
			
			arr.add(l);
		}
	}
}
