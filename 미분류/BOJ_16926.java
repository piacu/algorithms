import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1 2 3 4       2 3 4 8       3 4 8 6
5 6 7 8       1 7 7 6       2 7 8 2
9 8 7 6   →   5 6 8 2   →   1 7 6 3
5 4 3 2       9 5 4 3       5 9 5 4

4 4 2
1 2 3 4
5 6 7 8
9 8 7 6
5 4 3 2
*/

public class BOJ_16926 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] dr = { 0, 1, 0, -1 }; // 우 하 좌 상
		int[] dc = { 1, 0, -1, 0 };

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] resmap = null;

		for (int rpt = 0; rpt < R; rpt++) {

			resmap = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			int or = 0, oc = 0;

			while (!visited[or][oc]) {
				int r = or, c = oc, d = 0;
				while (d < 4) {

					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
						visited[nr][nc] = true;
						resmap[r][c] = map[nr][nc];
						r = nr;
						c = nc;

					} else d++;
				}

				or++;
				oc++;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = resmap[i][j];
				}
			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(resmap[i][j] + " ");
			}
			System.out.println();
		}

	}

}
