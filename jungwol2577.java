import java.io.*;
import java.util.*;

public class jungwol2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int type= 1;
		int answer = 0;
		int[] sushi = new int[N];
		int[] eat = new int[d];
		eat[c-1]=1;
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine())-1;
		}
		for (int i = 0; i < N+k; i++) {
			if(i>=k) {
				eat[sushi[i-k]]--;
				if(eat[sushi[i-k]]==0) type--;
			}
			if (eat[sushi[i%N]]==0) {
				type++;
			}
			eat[sushi[i%N]]++;
			answer=Math.max(answer, type);
		}
		
		System.out.print(answer);
	}
}
