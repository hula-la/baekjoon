import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static class Point {
		int p, w;
		Point(int p, int w){
			this.p=p;
			this.w=w;
		}
	}
	
    public int solution(int n, int[][] edges, int k, int a, int b) {
        int answer = -1;

        //그래프 구현
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<edges.length;i++){
            list.add(new ArrayList<Integer>());
        }
        //노드 연결
        int a, b;
        for(int[] node:edges){
            a=node[0];
            b=node[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        Queue<Point> q = new LinkedList<>;

        
        
        return answer;
    }
}