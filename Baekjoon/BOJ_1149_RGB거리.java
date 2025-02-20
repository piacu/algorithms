import java.util.Scanner;

public class BOJ_1149_RGB거리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int RGB[][] = new int[N+1][3];
		int dp[][] = new int[N+1][3];

		for (int i = 1; i <= N; i++) {
			RGB[i][0] = sc.nextInt();
			RGB[i][1] = sc.nextInt();
			RGB[i][2] = sc.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + RGB[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + RGB[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + RGB[i][2];
		}
		
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
		
		sc.close();
	}
}
