

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
	static int[][] map;
	static boolean v[][];
	static int N, Ans;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};

	static class Shark {
		int r, c, size=2;

		public Shark(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		Shark s = null;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					s = new Shark(i, j);
					map[i][j] = 0;
				}
			}
		}

		bfs(s);
		
		print();
		
		System.out.println(Ans);

	}

	private static void bfs(Shark shark) {
		Queue<Shark> q = new LinkedList<>();
		q.add(shark);
		v[shark.r][shark.c] = true;
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				Shark s = q.poll();
				
				for(int d=0; d<4; d++) {
					int nr = s.r + dr[d];
					int nc = s.c + dc[d];
					
					if(nr>=0 && nr<N && nc>=0 && nc<N && !v[nr][nc] && map[nr][nc] < s.size) {
						v[nr][nc] = true;
						q.add(new Shark(nr,nc));
						
						
					}
				}
			}

		}

	}

	private static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
