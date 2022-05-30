

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468 {
	static int[][] map;
	static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dc = {1, 0, -1, 0};
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int min = 100, max=0, res=0;
		
		map = new int[N][N]; // 지형의 높이 입력
		v = new boolean[N][N]; // 지형을 방문했을때 true
		
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(map[i][j], min);
				max = Math.max(map[i][j], max);
			}
		}
		
		for(int depth=min-1; depth<=max; depth++) { // min 부터 max 까지의 깊이를 구해서 침수하지 않은 부분(안전영역) 구하는 반복문
			int cnt=0; // 침수되지 않은 구역이 몇개인지 체크
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!v[i][j] && map[i][j] > depth) { // 현재 가리키는 위치가 false(방문 안함) 그리고 현재 위치가 depth보다 높을때(침수되지 않음)
						dfs(i, j, depth, v); // 물에 잠기지 않은 구역에 true 표시
						cnt++; // 구역을 확인하는 dfs를 실행했으니 구역 ++
						
					}
				}
			}

			//print(v);
			v = new boolean[N][N];
			res = Math.max(res, cnt);
		}
		
		System.out.println(res);
		
	}
	
	private static void dfs(int r, int c, int depth, boolean[][] v) {
		
		// logic
		if(map[r][c] > depth) v[r][c] = true; // depth보다 숫자가 높으면 침수 안되고 체크함
		// inductive 
		for(int i=0; i<4; i++) { // 사방탐색
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// 범위 내인가 체크, 체크하지 않은 곳일 때, depth보다 클때
			if(nr>=0 && nr<map.length && nc>=0 && nc<map.length && !v[nr][nc] && map[nr][nc] > depth) { 
				dfs(nr, nc, depth, v);
			}
		}
		
	}
	
}
