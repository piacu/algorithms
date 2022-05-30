

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {
	static int[] dr = {-1, 0, 1}; // 우상 우 우하
	static int[] dc = { 1, 1, 1};
	static char[][] map;
	static boolean[][] v;
	static int R, C;
	static int cnt;
	static boolean check;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		v = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String str = bf.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<R; i++) {
			check = false;
			pipeLine(i, 0);
			
		}
		
		System.out.println(cnt);
		
	}
	private static void pipeLine(int r, int c) {
		if(c == C-1) {
			check = true;
			cnt++;
			return;
		}

		
		for(int i=0; i<3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>=0 && nr < R && nc >=0 && nc < C && map[nr][nc] !='x' && !v[nr][nc] && !check) {
				v[nr][nc] = true;
				pipeLine(nr, nc);
			}
			
		}
		
	}
}
