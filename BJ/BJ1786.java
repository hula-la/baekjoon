package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ1786 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		int tLength = text.length, pLength = pattern.length;
		
		int[] pi = new int[pLength];
	    for(int i=1, j=0; i<pLength; i++){
	    	//
	        while(j > 0 && pattern[i] != pattern[j]) j = pi[j-1]; 
	        
	        if(pattern[i] == pattern[j]) pi[i] = ++j;
	        else pi[i] = 0;
	    }
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0,j=0; i<tLength; ++i) { 
			
			while(j>0 && text[i] != pattern[j]) j = pi[j-1]; 
			
			if(text[i] == pattern[j]) {
				if(j == pLength-1) { 
					cnt++; 
					list.add((i+2)-pLength);  
					j=pi[j]; 
				}else { 
					j++;
				}
			}
		}
		
		sb.append(cnt+"\n");
		for(int i:list) {
			sb.append(i+"\n");
		}
		System.out.println(sb);
	}
}
