import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Algo {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static int map[][],  dp[][];
   static int rowNum,colNum,ans;
   static int d[][] = {{1,0},{-1,0},{0,1},{0,-1}};
   public static void main(String[] args) throws NumberFormatException, IOException {
      int testCaseNum = Integer.parseInt(br.readLine());
      
      for(int testCaseIndex = 1;testCaseIndex<=testCaseNum;++testCaseIndex) {
         String[] s = br.readLine().split(" ");
         rowNum = sToI(s[0]);
         colNum = sToI(s[1]);
         map = new int[rowNum][colNum];
         dp = new int[rowNum][colNum];
         ans=0;
         for(int i=0;i<rowNum;++i) {
            s = br.readLine().split(" ");
            for(int j=0;j<colNum;++j) {
               map[i][j]=sToI(s[j]);
               dp[i][j]=0;
            }
         }
         BFS();
         System.out.println("#"+testCaseIndex+" "+ans);
      }
   }
   
   private static void BFS() {
      /*
       * BFS로 내려갈 수 있으면 q에 넣고 쭉 가다가 만약에 마지막 도착지에 도달한 경우를 세어주는 알고리즘을 사용한다.
       */
      Queue<Pos> q = new LinkedList<Pos>();
      q.offer(new Pos(0,0));
      dp[0][0]=1;
      while(!q.isEmpty()) {
         Pos polled = q.poll();
         // 목적지에 도착하면 ans++
         if(polled.i==rowNum-1 && polled.j==colNum-1) {
            ans++;
         }
         for(int i=0;i<4;++i) {
            int nextI = polled.i+d[i][0];
            int nextJ = polled.j+d[i][1];
            // map에 안 벗어나고
            if(nextI>=0 && nextI <map.length && nextJ>=0 && nextJ< map[0].length) {
               // 내려갈 수 있으면 넣는다.
               if(map[nextI][nextJ]<map[polled.i][polled.j]) {
                  q.offer(new Pos(nextI,nextJ));
               }
            }
         }
      }
   }

   static int sToI(String s ) {return Integer.parseInt(s);}
   
   static class Pos{
      int i;
      int j;
      public Pos(int i, int j) {
         super();
         this.i = i;
         this.j = j;
      }
      
   }
}