package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2628 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int maxW = 0,maxH = 0;
		
		ArrayList<Integer> arrR = new ArrayList<Integer>(Arrays.asList(0,H));
		ArrayList<Integer> arrC = new ArrayList<Integer>(Arrays.asList(0,W));


		for(int i=0;i<N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st2.nextToken());
			int idx = Integer.parseInt(st2.nextToken());
			if (dir==0) {
				arrR.add(idx);
			}else {
				arrC.add(idx);
			}
		}
		Collections.sort(arrR);
		Collections.sort(arrC);
		
		for(int i=1;i<arrR.size();i++) {
			maxH=Math.max(maxH, arrR.get(i)-arrR.get(i-1));
		}
		for(int i=1;i<arrC.size();i++) {
			maxW=Math.max(maxW, arrC.get(i)-arrC.get(i-1));
		}
		
		System.out.println(maxH*maxW);
	}

}
