import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_17070_파이프옮기기1 {
	static int cnt, N;
	static int map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0, 1, 0);
		
		System.out.println(cnt++);

	}
	private static void DFS(int r, int c, int dir) {
		if(r == N-1 && c == N-1) {
			cnt++;
			return;
		}
		
		switch(dir) {
		case 0: // 가로일 때
			if(c+1 < N && map[r][c+1] == 0) DFS(r, c+1, 0);
			break;
		case 1: // 세로일 때
			if(r+1 < N && map[r+1][c] == 0) DFS(r+1, c, 1);
			break;
		case 2: // 대각선일 경우 가로와 세로로 이동 가능
			if(c+1 < N && map[r][c+1] == 0) DFS(r, c+1, 0); // 가로
			if(r+1 < N && map[r+1][c] == 0) DFS(r+1, c, 1); // 세로
			break;
		}
		
		if(r+1 < N && c+1 < N && map[r][c+1] == 0 && map[r+1][c] == 0 && map[r+1][c+1] == 0){
			DFS(r+1, c+1, 2);
		}
		
	}

}
