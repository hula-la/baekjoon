package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] nums;
	static int N,M,len;
	static int answer=0;
	static int[][] zeroNums;
	static int count = 0;
	static boolean visited[];
	static int[] privateN;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// ?°?´?„° ?½ê¸°ë?? ?œ„?•œ ë²„í¼?“œë¦¬ë” ?ƒ?„±
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ?Œ¨?Š¤?›Œ?“œ ìµœëŒ“ê°?  N ?…? ¥
		N = Integer.parseInt(br.readLine());
		// ?Œ¨?Š¤?›Œ?“œ?˜ ê°œìˆ˜  M ?…? ¥
		M = Integer.parseInt(br.readLine());
		// ?Œ¨?Š¤?›Œ?“œ ?…? ¥?„ ?œ„?•œ ?Š¤?Š¸ë§í† ?¬?‚˜?´?? ?ƒ?„±
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N?˜ ìµœë?ê¸¸ì´ len
		len = Integer.toBinaryString(N).length();
		System.out.println("len");
		System.out.println(len);
		
		// nums
		nums = new int[N][len];
		
		// ê°? ?¸?±?Š¤?—?„œ 0ê³? 1?˜ ê°??ˆ˜ë¥? ?‚˜???‚´?Š” zeroNums ?ƒ?„±
		zeroNums = new int[len][2];
		
		// 2ì§„ìˆ˜ ?…? ¥
		for(int i=0;i<M;i++) {
			int n =Integer.parseInt(st.nextToken());
			char[] a = Integer.toBinaryString(n).toCharArray();
			System.out.println(Integer.toBinaryString(n));
			
			for(int j=len-a.length;j<len;j++) {
				nums[i][j] = a[j-len+a.length]-'0';
			}
		}
		
		int max = 0;
		int maxIdx = 0;
		int isOne = 0;
		
		// ê°? idx?—?„œ 0ê°??ˆ˜?? 1ê°??ˆ˜
		for(int i=0;i<len;i++) {
			for(int j=0;j<M;j++) {
				zeroNums[i][0] +=  nums[j][i]!=1?1:0;
				zeroNums[i][1] +=  nums[j][i]==1?1:0;
			}
			
			if (max<zeroNums[i][0]) {
				max = zeroNums[i][0];
				maxIdx = i;
				isOne = 0;
			} else if (max<zeroNums[i][1]){
				max = zeroNums[i][1];
				maxIdx = i;
				isOne = 1;
			}
		}
		
		System.out.println("zeroNums");
		for(int[] i:zeroNums) {
			System.out.print(i[1]+" ");
		}
		System.out.println();
		
		visited = new boolean[len];
		privateN = new int[M];
		
		
		int[] check = new int[len];
		
		int min = 0;
		for(int i=0;i<len;i++) {
			visited[maxIdx] = true;
			check[maxIdx] = isOne;
			
			// ?•ˆ? „ê¸¸ì´ ì¤? ìµœì†Ÿê°? ?œ„ì¹? ì°¾ê¸°
			min = 100;
			int minIdx = 0;
			for(int j=0;j<M;j++) {
				privateN[j] += nums[j][maxIdx]==isOne?1:0;
				if (privateN[j]<min) {
					minIdx = j;
					min = privateN[j];
				}
			}
			System.out.println("maxIdx");
			System.out.println(maxIdx);
			System.out.println("check");
			for(int k:check) {
				System.out.print(k+" ");
			}
			
			System.out.println("privateN");
			for(int k:privateN) {
				System.out.print(k+" ");
			}
			
			max = 0;
			maxIdx = 0;
			isOne = 0;
			// ìµœì†Ÿê°’ì„ ê°?ì§??Š” ?ˆ˜?—?„œ ê°??¥ ê°??ˆ˜ê°? ë§ì? ?¸?±?Š¤ ì°¾ê¸°
			for(int j=0;j<len;j++) {
				if (visited[j]==true) continue;
				if (max<zeroNums[j][nums[minIdx][j]]) {
					max = zeroNums[j][nums[minIdx][j]];
					maxIdx = j;
					isOne = nums[minIdx][j];
				}
			}

		}
		System.out.println();
		System.out.println(min);
//		System.out.println("check");
//		for(int i:check) {
//			System.out.print(i+" ");
//		}
//		System.out.println("privateN");
//		for(int i:privateN) {
//			System.out.print(i+" ");
//		}
		
	}
	
}
