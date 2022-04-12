package SWEA;

import java.io.*;
import java.util.*;
 
public class SWEA3307 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> rank = new ArrayList<>();
//            rank.add(Integer.parseInt(st.nextToken()));
            for (int j = 0; j < N; j++) {
            	int a = Integer.parseInt(st.nextToken());
                int idx = binarySearch(rank,a);
                System.out.println(idx);
                if (idx==rank.size()) rank.add(a);
                else rank.set(idx, a);
            }
            sb.append("#"+i+" "+rank.size()+"\n");
            System.out.println(rank.toString());
        }
        System.out.print(sb);
    }
    
    static int binarySearch(List<Integer> list, int t) {
    	int s=0;
    	int e=list.size()-1;
    	int mid;
    	while(s<=e) {
    		mid=(s+e)/2;
    		if(list.get(mid)>t) e=mid-1;
    		else s=mid+1;
    	}
    	return s;
    }
}