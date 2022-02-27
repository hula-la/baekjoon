package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2784 {
	static String[] arr = new String[3];
	static String[] word;
	static boolean[] visited = new boolean[6];
	static boolean find;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		word = new String[6];
		for (int i = 0; i < 6; i++) {
			word[i] = br.readLine();
		}
		
		
		permu(0);
		
		if (find) {
			for(String s:arr) {
				System.out.println(s);
			}
		}else {
			System.out.println(0);
		}
	}
	static void permu(int cnt) {
		if (cnt==3) {
			if(check()) {
				find=true;
			}
		}
		else{
			for (int i = 0; i < 6; i++) {
				if(!visited[i]&&!find) {
					visited[i]=true;
					arr[cnt]=word[i];
					permu(cnt+1);
					visited[i]=false;
				}
			}
		}
	}
	static boolean check() {
		boolean[] partvisited = visited.clone();
		
		col:for (int j = 0; j < 3; j++) {
			total:for (int i = 0; i < 6; i++) {
				for (int j2 = 0; j2 < 3; j2++) {
					if(partvisited[i]||arr[j2].charAt(j)!=word[i].charAt(j2)) {
						if (i==5) return false;
						else continue total;
					}
				}
				partvisited[i]=true;
				continue col;
			}
		}
		return true;
	}
}
