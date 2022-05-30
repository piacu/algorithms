

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class loc {
	int r;
	int c;
	int cnt;

	public loc(int r, int c, int cnt) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class BOJ_2146_다리만들기 {
	static int N;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		int Ans = 999999;

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬에 표시된 숫자를 다 다르게 바꾸어 이어지지 않는 땅을 구분할 수 있게 만드는 코드
		int mapNo = 2;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 1 && !v[i][j]) {
					map_divide(i, j, mapNo++);
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] != 0) {
					Ans = Math.min(Ans, bfs(i, j, new boolean[N][N]));
				}
			}
		}

		System.out.println(Ans-1);

	}

	private static int bfs(int r, int c, boolean[][] vs) {
		Queue<loc> q = new LinkedList<>();
		q.add(new loc(r, c, 0));
		int mapNum = map[r][c];

		while (!q.isEmpty()) {
			loc p = q.poll();
			if (map[p.r][p.c] != 0 && map[p.r][p.c] != mapNum) {
				return p.cnt;
			}

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != mapNum && !vs[nr][nc]) {
					vs[nr][nc] = true;
					q.add(new loc(nr, nc, p.cnt+1));
				}
			}
		}
		return 999999;
	}
	
	private static void map_divide(int i, int j, int mapNum) {
		Queue<loc> q = new LinkedList<>();
		q.add(new loc(i, j,0));
		v[i][j] = true;

		while (!q.isEmpty()) {
			loc p = q.poll();

			map[p.r][p.c] = mapNum;

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 0 && !v[nr][nc]) {
					v[nr][nc] = true;
					q.add(new loc(nr, nc,0));
				}
			}
		}

	}

}
