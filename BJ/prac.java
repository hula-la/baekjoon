package BJ;

public class prac {
	public static void main(String[] args) {
		System.out.println(fun10(3,5));
			
	}
	static int fun10(int a, int b) {
		if (b==0) return 1;
		if(b%2==0) return fun10(a*a,b/2);
		return fun10(a*a,b/2)*a;
	}
}
