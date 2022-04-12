import java.io.*;
import java.util.*;
  
public class Solution {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int max = 0;
            int ans = 0;
            for (int j = 0; j < N; j++) {
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
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