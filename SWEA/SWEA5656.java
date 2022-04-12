package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA5656 {
	static int N,W,H;
	static int[][] map;
	static int[][] midMap;
	static int min;
	static int[] dx =  {0,1,0,-1};
	static int[] dy =  {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
         
        for (int i = 1; i <= T; i++) {
        	min=Integer.MAX_VALUE;
        	
        	st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            
            int rest = 0;
            
            for (int j = 0; j < H; j++) {
            	st = new StringTokenizer(br.readLine());
            	for (int k = 0; k < W; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
					if (map[j][k]!=0) rest++;
				}
            }
            combination(0,map);
            sb.append("#"+i+" "+min+"\n");
        }
        System.out.print(sb);
	}
	
	static void combination(int cnt, int[][] afterMap) {
		System.out.println("cnt"+cnt);
		if (cnt==N) {
			int rest=0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(afterMap[i][j]!=0) rest++;
				}
			}
			min = Math.min(min, rest);
		}
		else {
			for (int i = 0; i < W; i++) {
				c:for (int j = 0; j <H; j++) {
					if (afterMap[j][i]!=0) {
						midMap=copyMap(afterMap);
						afterCrash(j,i,midMap[j][i],copyMap(afterMap));
						down(midMap);
						
						System.out.println(i);
						System.out.println(j);
						
						for (int a = 0; a < H; a++) {
							for (int b = 0; b < W; b++) {
								System.out.print(midMap[a][b]+" ");
							}
							System.out.println();
						}
						System.out.println();
						
						
						combination(cnt+1,copyMap(midMap));
						break c;
					}
				}
				
			}
		}
	}
	
	static void afterCrash(int x, int y, int num, int[][] map){
		int nx = x;
		int ny = y;
		midMap[nx][ny]=0;
		for (int i = 0; i < 4; i++) {
			int n=1;
			while(n<num) {
				nx+=dx[i];
				ny+=dy[i];
				if (nx<0||nx>=H||ny<0||ny>=W) break;
				else if (map[nx][ny]!=0) {
					midMap[nx][ny]=0;
					afterCrash(nx,ny,map[nx][ny], map);
					n++;
				}
			}
		}
		
		
	}
	static void down(int[][] map){
		for (int i = 0; i < W; i++) {
			int idx=H-1;
			for (int j = H-1; j >=0; j--) {
				if(map[j][i]!=0) {
					if (idx!=j) {
						map[idx][i]=map[j][i];
						map[j][i]=0;
					}
					idx--;
				}
			}
		}
	}
	static int[][] copyMap(int[][] map){
		int[][] copy = new int[H][W];
		for (int j = 0; j < H; j++) {
			for (int k = 0; k < W; k++) {
				copy[j][k] = map[j][k];
			}
		}
		return copy;
	}
}
