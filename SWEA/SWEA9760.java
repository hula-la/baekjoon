package SWEA;

import java.io.*;
import java.util.*;

public class SWEA9760 {
	static String[] cards;
	static boolean[] visited;
	static HashMap<Integer,Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		map.put('T'-'0',10); 
		map.put('J'-'0',11);
		map.put('Q'-'0',12); 
		map.put('K'-'0',13); 
		map.put('A'-'0',1); 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i=1;i<=T;i++) {
			cards = new String[5];
			HashMap<Character, Integer> counterR=new HashMap<>();
			HashMap<Character, Integer> counterS=new HashMap<>();
			
			String ans;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0;j<5;j++) {
				cards[j]=st.nextToken();
				
				counterR.compute(cards[j].charAt(1), (k, v) -> (v == null) ? 1 : v+1);
				counterS.compute(cards[j].charAt(0), (k, v) -> (v == null) ? 1 : v+1);
			}
			if (isStraight()) {
				if (counterS.size()==1) ans="Straight Flush";
				else ans="Straight";
			} else if (counterR.size()==2){
				if(counterR.containsValue(4)) ans="Four of a Kind";
				else ans="Full House";
			} else if (counterR.size()==3) {
				if(counterR.containsValue(3)) ans="Three of a kind";
				else ans="Two pair";
			} else if(counterR.containsValue(2)) ans="One pair";
			else if (counterS.size()==1) ans="Flush";
			else ans="High card";
			
			sb.append("#"+i+" "+ans+"\n");
		}
		System.out.print(sb);
	}
	
	static boolean isStraight() {
		int[] rank=new int[5];
		for (int i = 0; i < 5; i++) {
			rank[i]=cards[i].charAt(1)-'0';
			if(!(rank[i]>=2&&rank[i]<=9)){
				rank[i]=map.get(rank[i]);
			}
		}
		Arrays.sort(rank);
		
		int s=1;
		int lst=rank[0];
		if (lst==1&&rank[1]==10) {
			s=2;
			lst=10;
		}
		for (int i = s; i < s+4; i++) {
			if(rank[i%5]!=lst+1) return false;
			lst=rank[i%5]==13?0:rank[i%5];
		}
		return true;
	}
}
