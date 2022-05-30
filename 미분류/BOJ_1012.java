

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012 {
	static int[][] map;
	static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dc = {1, 0, -1, 0};
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int cnt = 0;

			map = new int[M][N];

			for (int i = 0; i < K; i++) {
				StringTokenizer st2 = new StringTokenizer(bf.readLine());
				int r = Integer.parseInt(st2.nextToken());
				int c = Integer.parseInt(st2.nextToken());

				map[r][c] = 1;
			}
			
			v = new boolean[M][N];
			
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[0].length; j++) {
					if(map[i][j] == 1 && !v[i][j]) {
						cnt++;
						dfs(i, j, v);
					}
				}
			}
			System.out.println(cnt);
		}
		
	}

	private static void dfs(int r, int c, boolean[][] v) {
		// base
		
		// logic
		// inductive
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < map.length && nc >= 0 && nc < map[0].length && !v[nr][nc] && map[nr][nc] == 1) {
				v[nr][nc] = true;
				dfs(nr, nc, v);
			}
		}
		
	}
}
