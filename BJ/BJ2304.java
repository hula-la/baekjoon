package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ2304 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> height = new HashMap<Integer, Integer>();
		int[] idxArr = new int[N];
		int maxH = 0;
		
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			maxH = Math.max(maxH, h);
			height.put(idx,h);
			idxArr[i] = idx;
		}
		
		Arrays.sort(idxArr);
		int i=0;
		int j=N-1;
		int lstIdx = 0;
		int lstH = 0;
		int result = 0;
		
		while (height.get(idxArr[i])!=maxH) {
			if (height.get(idxArr[i])>lstH) {
				result += lstH*(idxArr[i]-lstIdx);
				lstH = height.get(idxArr[i]);
				lstIdx = idxArr[i];
			}
			i++;
		}
		result += lstH*(idxArr[i]-lstIdx);
		
		lstIdx = 0;
		lstH = 0;
		
		while (height.get(idxArr[j])!=maxH) {
			if (height.get(idxArr[j])>lstH) {
				result += lstH*(lstIdx-idxArr[j]);
				lstH = height.get(idxArr[j]);
				lstIdx = idxArr[j];
			}
			j--;
		}
		result += lstH*(lstIdx-idxArr[j]) + (idxArr[j]+1-idxArr[i])*maxH;
		
		System.out.println(result);
	}
}
