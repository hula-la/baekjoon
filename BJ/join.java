package bj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class join {
	public static void main(String[] args) {
		List<Integer> in = Arrays.asList(new Integer[] {1,2,3}) ;
//		System.out.println(in.get(0)[0]);
		
		List<int[]> in2 = new ArrayList<int[]>();
		in2.add(new int[]{1,2});
		in2.add(new int[]{1,2});
		
//		String[] a = {"asdf","asdf"};
//		System.out.println(String.join(" ",a));
		System.out.println(in.size()+" "+in2.size());
	}
}
