package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16935 {
	static String[][] arr;
	static String[][] tmp;
	static int N,M,R;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new String[N][M];
		
		// ë°°ì—´ ?ž…? ¥
		for (int i=0;i<N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			for (int j=0;j<M;j++) {
				arr[i][j] = st2.nextToken();
			}
		
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		// ?ˆœ?„œ ??ë¡? ?—°?‚°
		for(int r=0;r<R;r++) {
			int m = Integer.parseInt(st2.nextToken());
			switch(m) {
			case 1: m1(); break;
			case 2: m2(); break;
			case 3: m3(); m2(); break;
			case 4: m3(); m1(); break;
			case 5: m5(); break;
			case 6: m6(); break; 
			}		
		}
		
		// ë°°ì—´ ì¶œë ¥
		for (int x=0;x<N;x++) {
			for (int y=0;y<M;y++) {
				System.out.print(arr[x][y]+" ");
			}
			System.out.print("\n");
		}
	}
	
	static void m1() {
		tmp = new String[N][M];
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				tmp[i][j] = arr[N-i-1][j]; 
			}
		}
		arr = tmp;

	}
	
	static void m2() {
		tmp = new String[N][M];
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				tmp[i][j] = arr[i][M-j-1]; 
			}
		}
		arr = tmp;
	}
	
	static void m3() {
		tmp = new String[M][N];
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				tmp[j][i] = arr[i][j]; 
			}
		}
		arr = tmp;
		int temp=M;
		M=N;
		N=temp;
	}

	static void m5() {
		tmp = new String[N][M];
		
		for (int i=0;i<N/2;i++) {
			for (int j=0;j<M/2;j++) {
				tmp[i][j] = arr[i+N/2][j]; 
				
			}
		}
		for (int i=0;i<N/2;i++) {
			for (int j=M/2;j<M;j++) {
				tmp[i][j] = arr[i][j-M/2]; 
			}
		}
		for (int i=N/2;i<N;i++) {
			for (int j=M/2;j<M;j++) {
				tmp[i][j] = arr[i-N/2][j]; 
			}
		}
		for (int i=N/2;i<N;i++) {
			for (int j=0;j<M/2;j++) {
				tmp[i][j] = arr[i][j+M/2]; 
			}
		}
		arr = tmp;
	}
	
	static void m6() {
		tmp = new String[N][M];
		
		for (int i=0;i<N/2;i++) {
			for (int j=0;j<M/2;j++) {
				tmp[i][j] = arr[i][j+M/2]; 
			}
		}
		for (int i=0;i<N/2;i++) {
			for (int j=M/2;j<M;j++) {
				tmp[i][j] = arr[i+N/2][j]; 
			}
		}
		for (int i=N/2;i<N;i++) {
			for (int j=M/2;j<M;j++) {
				tmp[i][j] = arr[i][j-M/2]; 
			}
		}
		for (int i=N/2;i<N;i++) {
			for (int j=0;j<M/2;j++) {
				tmp[i][j] = arr[i-N/2][j]; 
			}
		}
		arr = tmp;
	}
}
