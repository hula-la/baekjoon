import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class solution1 {
	static class Point implements Comparable<Point>{
		int p, d;
		Point(int p, int d){
			this.p=p;
			this.d=d;
		}
		@Override
		public int compareTo(Point o) {
			return this.d-o.d;
		}
	}
	public static void main(String[] args) {
		int[][] answer = new int[2][];
		int[][] dist = {{0, 5, 2, 4, 1}, {5, 0, 3, 9, 6}, {2, 3, 0, 6, 3}, {4, 9, 6, 0, 3}, {1, 6, 3, 3, 0}};
		int max =0;
		int maxIdx=0;
		for (int i = 0; i < dist[0].length; i++) {
			if (dist[0][i] > max) {
				maxIdx=i;
				max=dist[0][i];
			}
		}
		
		
		int[] zero = dist[0].clone();
		int[] one = dist[maxIdx].clone();
		int cri = zero[maxIdx];
		
		PriorityQueue<Point> pq= new PriorityQueue<>();
		PriorityQueue<Point> pq1= new PriorityQueue<>(Collections.reverseOrder());
		pq.add(new Point(0,0));
		pq.add(new Point(maxIdx,cri));
		pq1.add(new Point(0,0));
		pq1.add(new Point(maxIdx,cri));
		
		for (int i = 1; i < dist.length; i++) {
			if (i==maxIdx)continue;
			if (one[i]>cri) {
				pq.add(new Point(i,-zero[i]));
				pq1.add(new Point(i,-zero[i]));
			} else {
				pq.add(new Point(i,zero[i]));
				pq1.add(new Point(i,zero[i]));
			}
		}
		
		
		int[] arr1 = new int[pq.size()];
		int[] arr2 = new int[pq.size()];
		int i=0;
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			Point now1 = pq1.poll();
			arr1[i] = now.p;
			arr2[i] = now1.p;
			i++;
		}
		
		if (arr1[0]<arr2[0]){
            answer[0] = arr1;   
            answer[1] = arr2;
        } else {
            answer[1] = arr1;   
            answer[0] = arr2;
        }
		
		System.out.println(Arrays.toString(answer[0]));
		System.out.println(Arrays.toString(answer[1]));
		
	}
}
