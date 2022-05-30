

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1520_내리막길 {
	static int N, M, cnt;
	static int[][] map, dp;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		dp = new int[N][M];
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		cnt = dfs_dp(0,0);
	
//		print(dp);
		System.out.println(cnt);
		sc.close();
	}
	private static void print(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	private static int dfs_dp(int r, int c) { // dp 사용
		if(r == N-1 && c == M-1) {
			return 1;
		}
		if(dp[r][c] != -1) {
			return dp[r][c];
		}
		dp[r][c] = 0;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M && map[r][c] > map[nr][nc]) {
				dp[r][c] += dfs_dp(nr, nc);
			}
		}
		
		return dp[r][c];
	}
	
	private static void dfs(int r, int c) { // 완탐. 시간초과 발생
		if(r == N-1 && c == M-1) {
			cnt++;
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M && map[r][c] > map[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}
}
