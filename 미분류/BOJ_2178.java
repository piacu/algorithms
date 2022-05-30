

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
	static boolean[][] v;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int N, M, count;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		v = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = bf.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(map, 0,0);
		
		System.out.println(map[N-1][M-1]);

	}
	
	private static void bfs(int[][] map, int r, int c){
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{r,c});
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			int size=q.size(); // 각 depth마다 멈춰주기 위한 size 고정
			
			//print(map);
			
			for(int i=0; i<size; i++) {
				int[] p = q.poll();
				//v[p[0]][p[1]] = true;
				
				for(int j=0; j<4; j++) {
					int nr = p[0] + dr[j];
					int nc = p[1] + dc[j];
					
					if(nr>=0 && nr<N && nc>=0 && nc<M && !v[nr][nc] && map[nr][nc] != 0) {
						q.offer(new int[] {nr, nc});
						v[nr][nc] = true;
						map[nr][nc] = map[p[0]][p[1]] +1;
					}
				}
				
								
			}
			
		}
		
	}
	
	static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
