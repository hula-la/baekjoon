package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class BJ1786_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		int TL = T.length;
		int PL = P.length;
		int[] pi = new int[PL];
		
		// 중복 정보 저장
		for (int i=1, j=0; i < PL; i++) {
			while(P[i]!=P[j] && j!=0) j=pi[j-1];
			if(P[i]==P[j]) pi[i]=++j;
		}
		
//		for(int a:pi) {
//			System.out.println(a);
//		}
		// 검사
		
		List<Integer> list = new LinkedList<Integer>();
		
		for (int i=0, j=0; i < TL; i++) {
			while(T[i]!=P[j] && j!=0) {
//				System.out.println(i+" "+j);
				j=pi[j-1];
			}
			if(T[i]==P[j]) {
				j++;
				if (j==PL) {
					list.add(i-PL+2);
					j=pi[j-1];
				}
			}
		}
		sb.append(list.size()+"\n");
		for(int i:list) {
			sb.append(i+"\n");
		}
		System.out.print(sb);
	}
}
