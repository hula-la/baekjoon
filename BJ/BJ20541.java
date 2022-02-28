package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ20541 {
	static Map<String,Object> folder = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String a=st.nextToken();
			String b=st.nextToken();
			switch(a) {
			case("mkalb"):mkalb(b);break;
			case("rmalb"):rmalb(b);break;
			case("insert"):insert(b);break;
			case("delete"):delete(b);break;
			case("ca"):ca(b);break;
			}
		}
		
	}
	
	static void mkalb(String a) {
		if(folder.containsKey(a)) {
			sb.append("duplicated album name"+"\n");
		} else {
			folder.put(a, new HashMap<>());
		}
	}
	static void rmalb(String a) {
		switch(a) {
		case("-1"):
			Object[] mapkey = folder.keySet().toArray();
			Arrays.sort(mapkey);
			folder.remove(mapkey[0]);
		case(0):
			
		}
	}
}
