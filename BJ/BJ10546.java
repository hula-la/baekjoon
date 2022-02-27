package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ10546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> dic = new HashMap<String, Integer>();
		
		for(int i=0;i<N;i++) {
			String name = br.readLine();
			try {
				dic.replace(name, dic.get(name)+1);
			}catch(Exception e){
				dic.put(name,1);
			}
		}
		
		for(int i=0;i<N-1;i++) {
			String name = br.readLine();
			dic.replace(name, dic.get(name)-1);
			if (dic.get(name) == 0) {
				dic.remove(name);
			}
		}
		System.out.println(dic.keySet().toArray()[0]);
		
	}

}
