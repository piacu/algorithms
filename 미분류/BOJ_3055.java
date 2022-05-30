import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Doge {

	int row;
	int col;

	public Doge(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
}

public class BOJ_3055 {
	static int R, C, cnt;
	static char[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		Doge start = null;
		Doge end = null;
		ArrayList<Integer> alist = new ArrayList<Integer>();

		v = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = bf.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					start = new Doge(i, j);
				} else if (map[i][j] == 'D') {
					end = new Doge(i, j);
				}
			}
		}

		bfs(start, end);

		print();
		
		System.out.println(cnt);

	}

	private static void bfs(Doge start, Doge end) {
		Queue<Doge> q = new LinkedList<>();
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		v[start.row][start.col] = true;
		q.add(start);

		while (!q.isEmpty()) {
			int depth = q.size();

			for (int sz = 0; sz < depth; sz++) {
				Doge p = q.poll();
				int row = p.row;
				int col = p.col;

				for (int d = 0; d < 4; d++) {
					int nr = row + dr[d];
					int nc = col + dc[d];

					if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.' && !v[nr][nc]) {
						map[nr][nc] = (char)(cnt+48+1);
						q.add(new Doge(nr, nc));
						v[nr][nc] = true;
					}
				}
			}
			cnt++;
		}
	}

	private static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
