package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1991 {
	static char [][] graph;
	static StringBuilder preS = new StringBuilder();
	static StringBuilder midS = new StringBuilder();
	static StringBuilder postS = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		graph = new char[N][2];
		
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = st.nextToken().charAt(0)-'A';
			graph[idx][0] = st.nextToken().charAt(0);
			graph[idx][1] = st.nextToken().charAt(0);
		}
		pre(0);
		mid(0);
		post(0);
		System.out.println(preS.toString());
		System.out.println(midS.toString());
		System.out.println(postS.toString());
	}
	static void pre(int i) {
		if (i!=-19) {
			preS.append((char)(i+'A'));
			pre(graph[i][0]-'A');
			pre(graph[i][1]-'A');
		}
	}
	static void mid(int i) {
		if (i!=-19) {
			mid(graph[i][0]-'A');
			midS.append((char)(i+'A'));
			mid(graph[i][1]-'A');
		}
	}
	static void post(int i) {
		if (i!=-19) {
			post(graph[i][0]-'A');
			post(graph[i][1]-'A');
			postS.append((char)(i+'A'));
		}
	}
}
