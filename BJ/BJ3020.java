package BJ;

import java.io.*;
import java.util.*;

public class BJ3020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> b = new PriorityQueue<>();
		List<Integer> t = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			
			if (i%2==0) b.add(a);
			else t.add(H-a+1);
		}
		
		Collections.sort(t);
		
		int ans1 = 0,ans2=0;
		
		while(!b.isEmpty()) {
			int now = b.poll();
			// 이분탐색
			int idx=biSearch(now, t);
			if (idx!=0) {
				if (idx==t.size()) {
					ans1=idx+b.size();
					ans2=t.get(idx)-now;
				} else {
					ans1=idx+b.size();
					ans2=t.get(idx)-now;
 				}
			}
			if (b.size()==0) {
				ans2=t.get(0)-now;
			}
		}
		System.out.print(ans1+" "+ans2);
	}
	
	static int biSearch(int t,List<Integer> arr) {
		int s=0;
		int e=arr.size()-1;
		int mid;
		while(s<=e) {
			mid=(s+e)/2;
			if (arr.get(mid)>t) e=mid-1;
			else s=mid+1;
		}
		return s;
	}
}
