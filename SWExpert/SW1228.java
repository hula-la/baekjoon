package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW1228 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for (int i = 0; i<10;i++) {
			LinkedList<String> origin = new LinkedList<>();
			int nArray = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			for (int j = 0; j<nArray;j++) {
				origin.add(st.nextToken());
			}
			
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");

			for (int k = 0; k<n;k++) {
				st2.nextToken();
				int x = Integer.parseInt(st2.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				for (int z = 0; z<y;z++) {
					origin.add(x++,st2.nextToken());
				}
			}
			
			System.out.print("#"+(i+1));
			for(int p = 0; p<10;p++) {
				System.out.print(" "+origin.get(p));
			}
			System.out.println();
		}
	}
}
