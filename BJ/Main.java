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
		// ?°?΄?° ?½κΈ°λ?? ?? λ²νΌ?λ¦¬λ ??±
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ?¨?€?? μ΅λκ°?  N ?? ₯
		N = Integer.parseInt(br.readLine());
		// ?¨?€??? κ°μ  M ?? ₯
		M = Integer.parseInt(br.readLine());
		// ?¨?€?? ?? ₯? ?? ?€?Έλ§ν ?¬??΄?? ??±
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N? μ΅λ?κΈΈμ΄ len
		len = Integer.toBinaryString(N).length();
		System.out.println("len");
		System.out.println(len);
		
		// nums
		nums = new int[N][len];
		
		// κ°? ?Έ?±?€?? 0κ³? 1? κ°??λ₯? ????΄? zeroNums ??±
		zeroNums = new int[len][2];
		
		// 2μ§μ ?? ₯
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
		
		// κ°? idx?? 0κ°???? 1κ°??
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
			
			// ?? κΈΈμ΄ μ€? μ΅μκ°? ?μΉ? μ°ΎκΈ°
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
			// μ΅μκ°μ κ°?μ§?? ??? κ°??₯ κ°??κ°? λ§μ? ?Έ?±?€ μ°ΎκΈ°
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
