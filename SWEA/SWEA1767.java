package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1767 {
	static int[] dx =  {0,1,0,-1};
	static int[] dy =  {1,0,-1,0};
	static List<Point> core;
	static int min,maxcnt,N,length,arrN;
	static class Point {
		int x,y;
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
         
        for (int i = 1; i <= T; i++) {
        	N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            core = new ArrayList<>();
            for (int j = 0; j < N; j++) {
            	st = new StringTokenizer(br.readLine());
            	for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
					if (map[j][k]==1) core.add(new Point(j,k));
				}
            }
            arrN = core.size();
            min=Integer.MAX_VALUE;
            maxcnt=0;
            DFS(0,0,0,map);
            sb.append("#"+i+" "+min+"\n");
        }
        System.out.print(sb);
	}
	static void DFS(int idx, int sum, int cnt,int[][] map) {
		if (maxcnt>arrN-idx+cnt) return;
		if (idx==arrN) {
			if (cnt>maxcnt) {
				maxcnt = cnt;
				min = sum;
			}
			else if (cnt==maxcnt) min = Math.min(min, sum);
			return;
		} else {
			Point now = core.get(idx);
			if (now.x==0||now.y==0||now.x==N-1||now.y==N-1) {
				DFS(idx+1, sum,cnt+1,map);
			} else {
				DFS(idx+1, sum,cnt,map);
				
				for (int i = 0; i < 4; i++) {
					length=0;
					int[][] nextMap = line(now.x,now.y,i,map);
					if (length==0) continue;
					DFS(idx+1,sum+length,cnt+1,nextMap);
				}
			}
		}
	}
	static int[][] line(int x, int y, int d, int[][] map){
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = map[i][j];
			}
		}
		int nx = x;
		int ny = y;
		while(true) {
			nx += dx[d]; 
			ny += dy[d]; 
			if (nx<0||nx>=N||ny<0||ny>=N) break;
			if (copy[nx][ny]==1) {
				length=0; 
				break;
			}
			copy[nx][ny] = 1;
			length++;
		}
		return copy;
	}
}
