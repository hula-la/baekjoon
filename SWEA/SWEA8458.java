package SWEA;

import java.io.*;
import java.util.*;

public class SWEA8458 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
		}
        
        for (int i = 0; i < T; i++) {
        	StringTokenizer s = new StringTokenizer(br.readLine());
        }
        
         
        for (int i = 1; i <= T; i++) {
        	int N = Integer.parseInt(br.readLine());
        	
        	int max = 0;
        	int ans = 0;
        	for (int j = 0; j < N; j++) {
        		String[] s=br.readLine().split(" ");
        		int x=Integer.parseInt(s[0]);
        		int y=Integer.parseInt(s[1]);
        		int n = Math.abs(x)+Math.abs(y);
        		if (j==0) max=n;
        		else {
        			max=Math.max(max, n);
    				if (n%2!=max%2) {
    					ans=-1;
    				}
        		}
			}
        	
        	if(ans!=-1) {
        		int s=1;
        		int sum=0;
        		while(true) {
        			if(sum>=max) {
        				if ((sum-max)%2==0) ans=s-1;
        				else {
        					if (s%2==0) ans=s+1;
        					else ans=s;
        				}
        				break;
        			}
        			sum+=s++;
        		}
        		
        	}
            
            sb.append("#"+i+" "+ans+"\n");
        }
        System.out.print(sb);
	}
}
