package BJ;

import java.io.*;
import java.util.*;

public class BJ16236 {
	static int babySize = 2;
	static int[][] map;
	static int nowX,nowY,N;
	static int[][] dl = {{-1,0},{0,-1},{0,1},{1,0}};
	static boolean[][] visited;
	static int answer=0;
	
	static class point implements Comparable<point>{
		int x,y,dis;
		point(int x, int y, int dis){
			this.x=x;
			this.y=y;
			// ?��?�� ?���?(nowX,nowY)?? x,y???�� 거리 
			this.dis=dis;
		}
		
		// 거리, ?��, ?�� ?��?��?��?���? ?��?��?���? ?��?�� compareTo ?��버라?��?��
		@Override
		public int compareTo(point o) {
			if(this.dis!=o.dis) return this.dis-o.dis;
			if(this.x!=o.x) return this.x-o.x;
			else return this.y-o.y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		// 맵입?�� 
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 9?�� ?��?�� ?��?�� ?���? ?��?��
				if(map[i][j]==9) {
					map[i][j]=0;
					nowX = i;
					nowY = j;
				}
			}
		}
		// ?��?��까�? 먹�? 물고�? ?�� 초기?��
		int eat=0;
		// 방문 리스?�� 초기?��
		visited = new boolean[N][N];
		
		// 물고기�?? 못찾?�� ?��(findL()==false)까�? 계속 반복
		while(findL()) {
			// 먹�? 물고�? �??�� 추�?
			eat++;
			// 먹�? �??��?�� ?��기상?��?��?��즈�? 같으�?, ?��기상?�� ?��기�? 커�?�?, 물고�? ?�� 초기?��
			if (eat==babySize) {
				babySize++;
				eat=0;
			}
			visited = new boolean[N][N];
		}
		
		// ?�� 출력
		System.out.println(answer);
	}
	
	// 먹을 물고�? 찾는 ?��?��
	static boolean findL() {
		// BFS�? ?��?�� ?��?��?��, ?��치에 ???�� ?��?��?��?���? ?���?�? ?��?�� ?��?��?��?�� ?��
		Queue<point> q = new PriorityQueue<point>();
		// ?��?�� ?��치�?? ?��?�� ?��?��?���? 방문 기록
		q.add(new point(nowX,nowY,0));
		visited[nowX][nowY] = true;
		
		// ?���? 비어�? ?��까�? 반복?���?, ?���? 빌때까�? 물고기�?? 찾�? 못하�? false 반환
		while(!q.isEmpty()) {
			// ?��?��?��?���? ?��?? �?(1.?���? �?�?, 2.?��?�� ?��?��, 3. ?��?�� ?���?)?�� poll
			point now = q.poll();
			// ?��?�� ?��치에 물고기�? 존재?���? ?��기상?��?�� ?��기보?�� ?��?���?,
			if (map[now.x][now.y]<babySize&&map[now.x][now.y]>0) {
				// ?��?��?��치로 ?��기상?�� ?��?��?���?,
				nowX = now.x;
				nowY = now.y;
				// �? 거리만큼 answer ?��?���?,
				answer += now.dis;
				// ?��?�� ?��치에 물고�? ?��?���?
				map[nowX][nowY] = 0;
				// 먹었?��?�� ?��미에?�� true 반환
				return true;
			}
			
			// ?��방탐?��
			for (int i = 0; i < 4; i++) {
				int nextX = dl[i][0]+now.x;
				int nextY = dl[i][1]+now.y;
				// ?��?�� ?��치�? ?��기상?�� ?��?��즈보?�� ?��거나 같고, ?��?��?���? 초과?���??���?, 방문?���? ?��?���? ?��?�� ?��?��
				if (nextX>=0&&nextY>=0&&nextX<N&&nextY<N&&!visited[nextX][nextY]&&map[nextX][nextY]<=babySize) {
					q.add(new point(nextX,nextY,now.dis+1));
					visited[nextX][nextY] = true;
				}
			}
			
		}
		return false;
	}
	
}
