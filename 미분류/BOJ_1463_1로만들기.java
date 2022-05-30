

import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	static int[] memo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int cnt = 0;
		
		memo = new int[num+1];
		
		// 1. 재귀 사용 -> 시간 초과
//		System.out.println(recursive(num, cnt));
		
		// 2. 하향식(Top-bottom) -> memoization에서 최적의 해를 구하지 못할 수 있음
//		System.out.println(recursive_memo(num, cnt));		
		
		// 3. 상향식(Bottom-up)
		System.out.println(dp(num, cnt));
		
		sc.close();
	}

	private static int dp(int num, int cnt) {
		memo[0] = 0;
		memo[1] = 0;
		
		for(int i=2; i<=num; i++) {
			memo[i] = memo[i-1]+1;
			if(i%2==0) memo[i] = Math.min(memo[i], memo[i/2]+1);
			if(i%3==0) memo[i] = Math.min(memo[i], memo[i/3]+1);
		}
		
		return memo[num];
	}

	private static int recursive_memo(int num, int cnt) {
		if(num == 1) {
			return cnt;
		}
		int n1 = 9876;
		int n2 = 9876;
		int n3 = 9876;
		
		if(memo[num] != 0) return memo[num];
		
		if(num % 3 == 0) n1 = recursive_memo(num/3, cnt+1);
		if(num % 2 == 0) n2 = recursive_memo(num/2, cnt+1);
		n3 = recursive_memo(num-1, cnt+1);
		
		return memo[num] = Math.min(n1, Math.min(n2, n3));
	}
	private static int recursive(int num, int cnt) {
		if(num == 1) {
			return cnt;
		}
		int n1 = 9876;
		int n2 = 9876;
		int n3 = 9876;
		
		if(num % 3 == 0) n1 = recursive(num/3, cnt+1);
		if(num % 2 == 0) n2 = recursive(num/2, cnt+1);
		n3 = recursive(num-1, cnt+1);
		
		return Math.min(n1, Math.min(n2, n3));
	}
}
