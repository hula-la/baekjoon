package BJ;

public class Truck{

	public static void main(String[] args) throws InterruptedException {
		long x=40000;
		long y=38001;
		long a=20000;
		long b=19000;
		
		double s = x*b-y*a;
		System.out.println(s);
		System.out.println(s==0);
	}

	// 계좌
	static class BankAccount {
		int balance;
		void deposit(int amount) {
			int temp = balance + amount;
			System.out.print("+");
			balance = temp;
		}
		void withdraw(int amount) {
			int temp = balance - amount;
			System.out.print("-");
			balance = temp;
		}
		int getBalance() {
			return balance;
		}
	}

	// 입금 프로세스
	static class Parent extends Thread {
		BankAccount b;
		Parent(BankAccount b) {
			this.b = b;
		}
		public void run() {   // run(): 쓰레드가 실제로 동작하는 부분(치환)
			for (int i = 0; i < 10; i++)
			  b.deposit(1000);
		}
	}

	// 출금 프로세스
	static class Child extends Thread {
		BankAccount b;
		Child(BankAccount b) {
			this.b = b;
		}
		public void run() {
			for (int i = 0; i < 10; i++)
			  b.withdraw(1000);
		}
	}
	
}
