package bj;

import java.util.Scanner;

public class BJ10157 {
	static int K;
	static int[] dx= {0,0,1,0,-1};
	static int[] dy = {0,1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		K = sc.nextInt();
		
		boolean[][] visited = new boolean[C+2][R+2];
		int x = 1;
		int y = 1;
		
		for (int i=0; i<R+2;i++) {
			visited[0][i] = true;
			visited[C+1][i] = true;
		}
		for (int i=0; i<C+2;i++) {
			visited[i][0] = true;
			visited[i][R+1] = true;
		}
		
		int dir = 1;
		
		if (K<=C*R) {
			K--;
			while(K!=0) {
				K--;
				
				visited[x][y] = true;
				
				if (visited[x+dx[dir]][y+dy[dir]]==true) {
					dir = ++dir==5?1:dir;
				}
				x+=dx[dir];
				y+=dy[dir];
				
			}
			System.out.print(x+" "+y);
		}
		else {
			System.out.print(0);
		}
		
	}

}
