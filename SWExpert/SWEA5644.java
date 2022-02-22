package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA5644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// 델타 좌표 설정
		int[] dx = {0,0,1,0,-1};
		int[] dy = {0,-1,0,1,0};
		
		
		// 테스트 케이스
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// M: 총 이동 수, A: BC 갯수
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int result = 0;
			
			// A와 B 현재 위치 설정
			int[] Aloc = {1,1};
			int[] Bloc = {10,10};
			
			// 이동 배열 생성
			int[] aMove = new int[M];
			int[] bMove = new int[M];

			// BC 배열 생성
			int[][] BC = new int[A][4];
			
			// A,B 이동 배열 입력
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				aMove[j] = Integer.parseInt(st2.nextToken());
				bMove[j] = Integer.parseInt(st3.nextToken());
			}

			// BC 정보 입력
			for(int j=0;j<A;j++) {
				StringTokenizer st4 = new StringTokenizer(br.readLine());
				for(int k=0;k<4;k++) {
					BC[j][k] = Integer.parseInt(st4.nextToken());
				}
			}
			
			// 이동
			for (int j=0;j<M;j++) {
				ArrayList<Integer> aBC = new ArrayList<>();
				ArrayList<Integer> bBC = new ArrayList<>();
				
				// BC 탐색
				for (int k=0;k<A;k++) {
					if (Math.abs(Aloc[0]-BC[k][0])+Math.abs(Aloc[1]-BC[k][1])<=BC[k][2]) {
						aBC.add(k);
					}
					if (Math.abs(Bloc[0]-BC[k][0])+Math.abs(Bloc[1]-BC[k][1])<=BC[k][2]) {
						bBC.add(k);
					}
				}
				Collections.sort(aBC,(a,b) -> BC[b][3]-BC[a][3]);
				aBC.sort((a,b) -> BC[b][3]-BC[a][3]);
				bBC.sort((a,b) -> BC[b][3]-BC[a][3]);
				
				int BCValueA = !aBC.isEmpty()?BC[aBC.get(0)][3]:0;
				int BCValueB = !bBC.isEmpty()?BC[bBC.get(0)][3]:0;
				
				if (!aBC.isEmpty()&&!bBC.isEmpty()&&aBC.get(0)==bBC.get(0)) {
				
					int max = 0;
					if (aBC.size()>=2) {
						max = Math.max(BC[aBC.get(1)][3], max);
					}
					if (bBC.size()>=2) {
						max = Math.max(BC[bBC.get(1)][3], max);
					}
					result += max + BCValueA;
				} else {
					result += BCValueA + BCValueB;
				}
				
				Aloc[1] += dy[aMove[j]];
				Bloc[1] += dy[bMove[j]];
				Aloc[0] += dx[aMove[j]];
				Bloc[0] += dx[bMove[j]];
			}
			
			sb.append("#"+i+" "+result+"\n");
		}

		System.out.println(sb);
	}
}

// 리스트를 만든 후에 정렬하지 않고 BC 배열을 생성할 때 정렬하면 더 편할 듯