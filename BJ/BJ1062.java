package BJ;

import java.io.*;
import java.util.*;

public class BJ1062 {
	static int K,ans,N;
	static boolean[] teach;
	static String[] word;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans=0;
		
		teach = new boolean[26];
		char[] basic = {'a','t','i','c','n'};
		for (int i = 0; i < 5; i++) {
			teach[basic[i]-'a']=true;
		}

		word = new String[N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			String tmp =s.substring(4, s.length()-4);
			word[i]=tmp;
		}
		if (K>=5) subset(0,0);
		System.out.print(ans);
		
	}
	
	static void subset(int idx, int cnt) {
		if (26-idx<K-5-cnt) return;
		if (cnt==K-5) {
			ans=Math.max(ans, check());
		} else {
			if (!teach[idx]) {
				teach[idx]=true;
				subset(idx+1,cnt+1);
				teach[idx]=false;
			}
			subset(idx+1,cnt);
		}
	}
	static int check() {
		int cnt=0;
		total: for (int i = 0; i < N; i++) {
			char[] wordtmp = word[i].toCharArray();
			for (char c: wordtmp) {
				if(!teach[c-'a']) continue total;
			}
			cnt++;
		}
		return cnt;
	}
}
