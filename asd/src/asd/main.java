package asd;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner zero = new Scanner(System.in);
		System.out.println("ют╥б :  ");
		int a = zero.nextInt();
		int b = zero.nextInt();

		class Add {
			private int a, b;

			public void nu(int a, int b) {
				this.a = a;
				this.b = b;
			}

			public int aaa() {
				return a + b;
			}
		}
		class ass {
			private int a, b;

			public void nu(int a, int b) {
				this.a = a;
				this.b = b;
			}

			public int aaa() {
				return a - b;
			}
		}
		class azz {
			private int a, b;

			public void nu(int a, int b) {
				this.a = a;
				this.b = b;
			}

			public int aaa() {
				return a * b;
			}
		}
		class axx {
			private int a, b;

			public void nu(int a, int b) {
				this.a = a;
				this.b = b;
			}

			public int aaa() {
				return a / b;
			}
		}
		char operator = zero.next().charAt(0);
		switch (operator) {
		case '+':
			
		case '-':
		case '*':
		case '/':
		}

	}

}
