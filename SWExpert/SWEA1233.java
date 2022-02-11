package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1233 {
	static int N;
	static String[] arr;
	static String[] oper = {"+","-","*","/"};
	static int isOper;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int j=1;j<=10;j++) {
			result = 1;
			isOper = 1;
			
			N = Integer.parseInt(br.readLine());
			arr = new String[N+1];
			
			for (int i=1;i<=N;i++) {
				arr[i] =br.readLine().split(" ")[1];
			}
			inOrder(1);
			if (isOper==1) {
				result = 0;
			}
			System.out.print("#"+j+" "+result+"\n");
			
		}
	}
	
	public static void inOrder(int x) {
		if(x>N) return;
		inOrder(x*2);
		
		
		if (Arrays.asList(oper).contains(arr[x])) {
			
			if (isOper==1){
				result = 0;
				return;
			}
			isOper=1;
		}
		else {
			if (isOper==0){
				result = 0;
				isOper=0;
				return;
			}
			isOper=0;
		}
		
		inOrder(x*2+1);

	}
}
