import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 말이되고픈원숭이 {
	static int[][] map;
	static int N, M, K;
	static int[] dr = {1,-1,0,0,-2,-1,1,2,2,1,-1,-2};
	static int[] dc = {0,0,1,-1,1,2,2,1,-1,-2,-2,-1};
	
	static class Point{
		int r, c, cnt, k;

		public Point(int r, int c, int cnt, int k) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[N+1][M+1];
		
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
//		print(map);
		bfs(1,1);
		
		sc.close();

	}
	private static void bfs(int r, int c) {
		Queue<Point> Q = new LinkedList<>();
		boolean[][][] v = new boolean[N+1][M+1][K+1];
		
		Q.add(new Point(r, c, 0, K));
		v[r][c][K] = true;
		int Ans = 987654321;
		while(!Q.isEmpty()){
			Point p = Q.poll();
			if(p.r == N && p.c == M) {
				Ans = Math.min(Ans, p.cnt);
				break;
			}
							// 말처럼 뛸 수 있으면 0~11 방향으로 뛰고
							// 원숭이처럼 할 수 있으면 0~3 방향으로 뛴다
			for(int d=0; d<(p.k>0?12:4); d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				int nk = d < 4 ? p.k : p.k-1;
				
				if(nr>=1 && nr<=N && nc>=1 && nc<=M && !v[nr][nc][nk] && map[nr][nc]!=1) {
					v[nr][nc][nk] = true;
					Q.add(new Point(nr, nc, p.cnt+1, nk));
				}
			}
		}
		System.out.println(Ans==987654321?-1:Ans);
		
	}
	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
