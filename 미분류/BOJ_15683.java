import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15683 {
	static int[][] map;
	static boolean[][] v;
	static int check;
	static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M]; 
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				if(map[i][j] > 0 && map[i][j]<6) check++;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] > 0 && map[i][j]<6) {
					dfs(i, j, map[i][j]);
				}
				
			}
		}
		
		
		
	} 
	
	
	private static void dfs(int r, int c, int input) {


		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
		}
		
	}

	private static int[][] dir(int input) {
		switch(input) {
		case 1:
			return new int[][] {{0
		}
	}





	static void print(int map[][]) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
