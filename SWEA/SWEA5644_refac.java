package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA5644_refac {
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
			int[][] loc = {{1,1}, {10,10}};
			
			// 이동 배열 생성
			int[][] move = new int[2][M];

			// BC 배열 생성
			int[][] BC = new int[A][4];
			
			// A,B 이동 배열 입력
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				move[0][j] = Integer.parseInt(st2.nextToken());
				move[1][j] = Integer.parseInt(st3.nextToken());
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
				int max[][] = new int[2][2];
				
				// BC 탐색
				for (int k=0;k<A;k++) {
					for (int n=0;n<2;n++) {
						if (Math.abs(loc[0][0]-BC[k][0])+Math.abs(loc[0][1]-BC[k][1])<=BC[k][2]) {
							if (BC[k][3]>max[n][0]) {
								max[n][0] = k;
							}
							else {
								max[n][1]
							}
						}
					}
				}
				// BC 처리량 내림차순으로 정렬
				aBC.sort((a,b) -> BC[b][3]-BC[a][3]);
				bBC.sort((a,b) -> BC[b][3]-BC[a][3]);
				
				// 가장 큰 값을 충전량에 할당
				int BCValueA = !aBC.isEmpty()?BC[aBC.get(0)][3]:0;
				int BCValueB = !bBC.isEmpty()?BC[bBC.get(0)][3]:0;
				
				int
				
				//
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
				
				move[0][0] += dx[move[0][j]];
				move[1][0] += dx[move[1][j]];
				move[0][1] += dy[move[0][j]];
				move[1][1] += dy[move[1][j]];
			}
			
			sb.append("#"+i+" "+result+"\n");
		}
		System.out.println(sb);
	}
}
