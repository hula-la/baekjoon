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
			// ??¬ ?μΉ?(nowX,nowY)?? x,y??? κ±°λ¦¬ 
			this.dis=dis;
		}
		
		// κ±°λ¦¬, ?, ?΄ ?°? ??λ‘? ? ? ¬?κΈ? ??΄ compareTo ?€λ²λΌ?΄?©
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
		
		// λ§΅μ? ₯ 
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 9?Ό ?? ??¬ ?μΉ? ?? ₯
				if(map[i][j]==9) {
					map[i][j]=0;
					nowX = i;
					nowY = j;
				}
			}
		}
		// ??¬κΉμ? λ¨Ήμ? λ¬Όκ³ κΈ? ? μ΄κΈ°?
		int eat=0;
		// λ°©λ¬Έ λ¦¬μ€?Έ μ΄κΈ°?
		visited = new boolean[N][N];
		
		// λ¬Όκ³ κΈ°λ?? λͺ»μ°Ύ? ?(findL()==false)κΉμ? κ³μ λ°λ³΅
		while(findL()) {
			// λ¨Ήμ? λ¬Όκ³ κΈ? κ°?? μΆκ?
			eat++;
			// λ¨Ήμ? κ°??? ?κΈ°μ?΄?¬?΄μ¦κ? κ°μΌλ©?, ?κΈ°μ?΄ ?¬κΈ°κ? μ»€μ?κ³?, λ¬Όκ³ κΈ? ? μ΄κΈ°?
			if (eat==babySize) {
				babySize++;
				eat=0;
			}
			visited = new boolean[N][N];
		}
		
		// ?΅ μΆλ ₯
		System.out.println(answer);
	}
	
	// λ¨Ήμ λ¬Όκ³ κΈ? μ°Ύλ ?¨?
	static boolean findL() {
		// BFSλ₯? ?? ???±, ?μΉμ ??? ?°? ??λ₯? ?°μ§?κΈ? ?? ?°? ?? ?
		Queue<point> q = new PriorityQueue<point>();
		// ??¬ ?μΉλ?? ?? ?½??κ³? λ°©λ¬Έ κΈ°λ‘
		q.add(new point(nowX,nowY,0));
		visited[nowX][nowY] = true;
		
		// ?κ°? λΉμ΄μ§? ?κΉμ? λ°λ³΅?κ³?, ?κ°? λΉλκΉμ? λ¬Όκ³ κΈ°λ?? μ°Ύμ? λͺ»νλ©? false λ°ν
		while(!q.isEmpty()) {
			// ?°? ??κ°? ??? κ³?(1.?μΉ? κ°?κΉ?, 2.? ?Ό ??, 3. ? ?Ό ?Όμͺ?)? poll
			point now = q.poll();
			// ?΄?Ή ?μΉμ λ¬Όκ³ κΈ°κ? μ‘΄μ¬?κ³? ?κΈ°μ?΄? ?¬κΈ°λ³΄?€ ??Όλ©?,
			if (map[now.x][now.y]<babySize&&map[now.x][now.y]>0) {
				// ?΄?Ή?μΉλ‘ ?κΈ°μ?΄ ?΄??κ³?,
				nowX = now.x;
				nowY = now.y;
				// κ·? κ±°λ¦¬λ§νΌ answer ??κ³?,
				answer += now.dis;
				// ?΄?Ή ?μΉμ λ¬Όκ³ κΈ? ?? κΈ?
				map[nowX][nowY] = 0;
				// λ¨Ήμ?€? ?λ―Έμ? true λ°ν
				return true;
			}
			
			// ?¬λ°©ν?
			for (int i = 0; i < 4; i++) {
				int nextX = dl[i][0]+now.x;
				int nextY = dl[i][1]+now.y;
				// ?΄?Ή ?μΉκ? ?κΈ°μ?΄ ?¬?΄μ¦λ³΄?€ ?κ±°λ κ°κ³ , ?Έ?±?€λ₯? μ΄κ³Ό?μ§??κ³?, λ°©λ¬Έ?μ§? ??Όλ©? ?? ?½?
				if (nextX>=0&&nextY>=0&&nextX<N&&nextY<N&&!visited[nextX][nextY]&&map[nextX][nextY]<=babySize) {
					q.add(new point(nextX,nextY,now.dis+1));
					visited[nextX][nextY] = true;
				}
			}
			
		}
		return false;
	}
	
}
