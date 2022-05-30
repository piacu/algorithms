

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026 {
	static char[][] map;
	static boolean[][] v;
	static boolean[][] v2;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new char[N][N];
		v = new boolean[N][N];
		int cnt1=0, cnt2=0;
		
		for(int i=0; i<N; i++) {
			String str = bf.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		//print();
		
		for(int r=0; r<N; r++) { // 체크
			for(int c=0; c<N; c++) {
				if(!v[r][c]) {
					dfs(r,c,map[r][c]);
					cnt1++;
				}
			}
		}
		
		v = new boolean[N][N]; // 방문배열 초기화
		
		for(int r=0; r<N; r++) { // Green 은 R로 변환
			for(int c=0; c<N; c++) {
				if(map[r][c] == 'G') {
					map[r][c] = 'R';
				}
			}
		}
		
		
		for(int r=0; r<N; r++) { // 적록색약용 체크
			for(int c=0; c<N; c++) {
				if(!v[r][c]) {
					dfs(r,c,map[r][c]);
					cnt2++;
				}
			}
		}
		
		print();
		System.out.println(cnt1+" "+cnt2);
		
		
			

	}
	
	private static void dfs(int r, int c, char ch) {
		
		v[r][c] = true;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && !v[nr][nc] && map[nr][nc] == ch) {
				dfs(nr,nc, ch);
			}
		}
		
	}

	static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
