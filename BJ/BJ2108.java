package BJ;

import java.io.*;
import java.util.*;

public class BJ2108 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		int sum=0;
		HashMap<Integer, Integer> counter=new HashMap<>();
		int mode = 0,frequency = 0,freF = 0;
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum+=arr[i];
			counter.compute(arr[i], (k, v) -> (v == null) ? 1 : v+1);
			if (counter.get(arr[i])>frequency) {
				mode=4001;
				freF=arr[i];
				frequency=counter.get(arr[i]);
			}
			else if (counter.get(arr[i])==frequency) {
				if(arr[i]<freF) {
					mode=freF;
					freF=arr[i];
				} else if(arr[i]<mode){
					mode=arr[i];
				}
			}
		}
		Arrays.sort(arr);
		System.out.print(Math.round((double)sum/N)+"\n"+arr[N/2]+"\n"+(mode==4001?freF:mode)+"\n"+(arr[N-1]-arr[0]));
	}
}
