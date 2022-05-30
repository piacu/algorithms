

import java.util.Scanner;

public class BOJ_11729_RE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		hanoi(num, 1, 2, 3);

	}

	private static void hanoi(int num, int from, int temp, int to) {
		if(num == 0) {
			return;
		}
		
		hanoi(num-1, from, to, temp);
		hanoi(num-1, from, temp, to);	
		hanoi(num-1, temp, from, to);
		
		
	}

}
