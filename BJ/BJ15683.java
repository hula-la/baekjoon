package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ15683 {
	static int[][] map;
	static ArrayList<ArrayList<Integer>> cctv;
	static int totalZ=0;
	static int answer=Integer.MAX_VALUE;
	static int[] cctvDN = {0,4,2,4,4,1};
	static boolean[] visited;
	static int[] dir;
	static int sum,N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int[][] temp = new int[N][M];
		
		cctv = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				if (a==0) totalZ++;
				else if (a>0 && a<6) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(i);
					tmp.add(j);
					tmp.add(a);
					cctv.add(tmp);
				}
			}
		}
		visited = new boolean[cctv.size()];
		dir = new int[cctv.size()];
//		System.out.println(cctv.size());
		
		find(0);
		System.out.println(answer);
	}
	
	static void find(int cnt) {
		if (cnt==cctv.size()) {
			sum=0;
			cal();
			answer = Math.min(answer, totalZ-sum);
//			System.out.println(sum);
//			for(int i:dir) {
//				System.out.print(i);
//			}
//			System.out.println("***********");
		} else {
			for (int i = 0; i < cctvDN[cctv.get(cnt).get(2)]; i++) {

					dir[cnt] = i;
					find(cnt+1);
			}
		}
	}
	
	static void cal() {
		int[][] temp = new int[N][M];
		for (int j = 0; j < N; j++) {
			for (int z = 0; z < M; z++) {
				temp[j][z] = map[j][z];
			}
		}
		
		for (int i = 0; i < cctv.size(); i++) {
			int type = cctv.get(i).get(2);
			int x = cctv.get(i).get(0);
			int y = cctv.get(i).get(1);
			
			switch (type) {
			case 1: move(x,y,dir[i],temp); break;
			case 2: move(x,y,dir[i],temp);move(x,y,dir[i]+2,temp); break;
			case 3:move(x,y,dir[i],temp);move(x,y,(dir[i]+1)%4,temp);break;
			case 4: move(x,y,dir[i],temp);move(x,y,(dir[i]+1)%4,temp);move(x,y,(dir[i]+2)%4,temp);break;
			case 5:move(x,y,dir[i],temp);move(x,y,(dir[i]+1)%4,temp);move(x,y,(dir[i]+2)%4,temp);move(x,y,(dir[i]+3)%4,temp);break;
			}
		}
//		print(temp);
//		System.out.println();
	}
	
	static void move(int x, int y, int i,int[][] map) {
		
		int[] dx = {0,-1,0,1};
		int[] dy = {1,0,-1,0};
//		System.out.println(i);
		while (true) {
			x += dx[i];
			y+= dy[i];
//			System.out.println("x"+x);
			if (x<0||x>=N||y<0||y>=M||map[x][y]==6) break;
			if (map[x][y]==0) sum++; map[x][y]=9;
		}
		
	}
	
//	static void print(int[][] map) {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//	}
}
