package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ7662 {
	static Map<Integer, Integer> delete;
	static PriorityQueue<Integer> pq1, pq2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			int k = Integer.parseInt(br.readLine());
			pq1 = new PriorityQueue<>(Collections.reverseOrder());
			pq2 = new PriorityQueue<>();
			
			delete = new HashMap<Integer, Integer>();
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				char oper = st.nextToken().charAt(0);
				
				switch(oper) {
				case('I'): 
					int a = Integer.parseInt(st.nextToken());
					if(delete.containsKey(a)) {
						delete.replace(a,delete.get(a)+1);
					} else {
						delete.put(a,1);
					}
					pq1.add(a);
					pq2.add(a);
					break;
				case('D'):
					int n = Integer.parseInt(st.nextToken());
					findValue(n);
				}
				
			}
			Integer a = findValue(1);
			Integer b = findValue(0);
			if(a==null&&b==null) {
				sb.append("EMPTY"+"\n");
			} else {
				sb.append(a+" "+(b==null?a:b)+"\n");
			}
		}
		System.out.println(sb);
	}
	
	static Integer findValue(int n) {
		while(true){
			Integer b = (n==1?pq1:pq2).poll();
//			System.out.println(b==null);
			if(b==null) {
				return b;
			}else if(delete.get(b)>=1) {
				delete.replace(b,delete.get(b)-1);
				return b;
			} 
		}
	}
}
