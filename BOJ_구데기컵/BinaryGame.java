package 구데기컵;

import java.util.Scanner;

public class BinaryGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for(int i=0; i<=N; i++) {
			String txt = Integer.toBinaryString(i);
			System.out.print(txt);
		}

	}

}
