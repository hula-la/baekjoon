package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1244 {
	static int N;
	static String[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = br.readLine().split(" ");
		
		int studentN = Integer.parseInt(br.readLine());
		
		for (int i=0;i<studentN;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			changeNum(sex,num);
		}
		for (int j=0;j<N;j++) {	
			System.out.print(arr[j]+" ");
			if ((j+1)%20==0) {
				System.out.print("\n");
			}
		}
		
		
	}
	
	static void changeNum(int sex, int num) {
		switch(sex) {
		case 1:
			for(int i=num;i<=N;i+=num) {
				arr[i-1]=arr[i-1].equals("0")?"1":"0";
			}
			break;
		case 2:
			int range=1;
			
			while((num>range&&num<=N-range)&&arr[num+range-1].equals(arr[num-range-1])) {
				range++;
			}
	
			
			for(int i=num-range+1;i<num+range;i++) {
				arr[i-1]=arr[i-1].equals("0")?"1":"0";
			}
			break;
			
		
		}
	}

}
