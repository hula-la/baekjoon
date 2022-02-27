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
			// ?˜„?¬ ?œ„ì¹?(nowX,nowY)?? x,y???˜ ê±°ë¦¬ 
			this.dis=dis;
		}
		
		// ê±°ë¦¬, ?–‰, ?—´ ?š°?„ ?ˆœ?œ„ë¡? ? •? ¬?•˜ê¸? ?œ„?•´ compareTo ?˜¤ë²„ë¼?´?”©
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
		
		// ë§µì…? ¥ 
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 9?¼ ?•Œ?Š” ?˜„?¬ ?œ„ì¹? ?…? ¥
				if(map[i][j]==9) {
					map[i][j]=0;
					nowX = i;
					nowY = j;
				}
			}
		}
		// ?˜„?¬ê¹Œì? ë¨¹ì? ë¬¼ê³ ê¸? ?ˆ˜ ì´ˆê¸°?™”
		int eat=0;
		// ë°©ë¬¸ ë¦¬ìŠ¤?Š¸ ì´ˆê¸°?™”
		visited = new boolean[N][N];
		
		// ë¬¼ê³ ê¸°ë?? ëª»ì°¾?„ ?•Œ(findL()==false)ê¹Œì? ê³„ì† ë°˜ë³µ
		while(findL()) {
			// ë¨¹ì? ë¬¼ê³ ê¸? ê°??ˆ˜ ì¶”ê?
			eat++;
			// ë¨¹ì? ê°??ˆ˜?‘ ?•„ê¸°ìƒ?–´?‚¬?´ì¦ˆê? ê°™ìœ¼ë©?, ?•„ê¸°ìƒ?–´ ?¬ê¸°ê? ì»¤ì?ê³?, ë¬¼ê³ ê¸? ?ˆ˜ ì´ˆê¸°?™”
			if (eat==babySize) {
				babySize++;
				eat=0;
			}
			visited = new boolean[N][N];
		}
		
		// ?‹µ ì¶œë ¥
		System.out.println(answer);
	}
	
	// ë¨¹ì„ ë¬¼ê³ ê¸? ì°¾ëŠ” ?•¨?ˆ˜
	static boolean findL() {
		// BFSë¥? ?œ„?•œ ??ƒ?„±, ?œ„ì¹˜ì— ???•œ ?š°?„ ?ˆœ?œ„ë¥? ?”°ì§?ê¸? ?œ„?•œ ?š°?„ ?ˆœ?œ„ ?
		Queue<point> q = new PriorityQueue<point>();
		// ?˜„?¬ ?œ„ì¹˜ë?? ??— ?‚½?…?•˜ê³? ë°©ë¬¸ ê¸°ë¡
		q.add(new point(nowX,nowY,0));
		visited[nowX][nowY] = true;
		
		// ?ê°? ë¹„ì–´ì§? ?•Œê¹Œì? ë°˜ë³µ?•˜ê³?, ?ê°? ë¹Œë•Œê¹Œì? ë¬¼ê³ ê¸°ë?? ì°¾ì? ëª»í•˜ë©? false ë°˜í™˜
		while(!q.isEmpty()) {
			// ?š°?„ ?ˆœ?œ„ê°? ?†’?? ê³?(1.?œ„ì¹? ê°?ê¹?, 2.? œ?¼ ?œ„?—, 3. ? œ?¼ ?™¼ìª?)?„ poll
			point now = q.poll();
			// ?•´?‹¹ ?œ„ì¹˜ì— ë¬¼ê³ ê¸°ê? ì¡´ì¬?•˜ê³? ?•„ê¸°ìƒ?–´?˜ ?¬ê¸°ë³´?‹¤ ?‘?œ¼ë©?,
			if (map[now.x][now.y]<babySize&&map[now.x][now.y]>0) {
				// ?•´?‹¹?œ„ì¹˜ë¡œ ?•„ê¸°ìƒ?–´ ?´?™?•˜ê³?,
				nowX = now.x;
				nowY = now.y;
				// ê·? ê±°ë¦¬ë§Œí¼ answer ?”?•˜ê³?,
				answer += now.dis;
				// ?•´?‹¹ ?œ„ì¹˜ì— ë¬¼ê³ ê¸? ?—†?• ê¸?
				map[nowX][nowY] = 0;
				// ë¨¹ì—ˆ?‹¤?Š” ?˜ë¯¸ì—?„œ true ë°˜í™˜
				return true;
			}
			
			// ?‚¬ë°©íƒ?ƒ‰
			for (int i = 0; i < 4; i++) {
				int nextX = dl[i][0]+now.x;
				int nextY = dl[i][1]+now.y;
				// ?•´?‹¹ ?œ„ì¹˜ê? ?•„ê¸°ìƒ?–´ ?‚¬?´ì¦ˆë³´?‹¤ ?‘ê±°ë‚˜ ê°™ê³ , ?¸?±?Š¤ë¥? ì´ˆê³¼?•˜ì§??•Šê³?, ë°©ë¬¸?•˜ì§? ?•Š?œ¼ë©? ??— ?‚½?…
				if (nextX>=0&&nextY>=0&&nextX<N&&nextY<N&&!visited[nextX][nextY]&&map[nextX][nextY]<=babySize) {
					q.add(new point(nextX,nextY,now.dis+1));
					visited[nextX][nextY] = true;
				}
			}
			
		}
		return false;
	}
	
}
