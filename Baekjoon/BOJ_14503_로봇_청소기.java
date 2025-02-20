import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇_청소기 { // 25:30

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		
		int rR = Integer.parseInt(st.nextToken());
		int rC = Integer.parseInt(st.nextToken());
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		int d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		while(true) {
			if(map[rR][rC] == 0) {
				map[rR][rC] = 9;
				++ans;
			}
			
			boolean flag = false;
			for(int i=0; i<4; ++i) {
				int tR = rR + dr[i];
				int tC = rC + dc[i];
				
				if(tR < 0 || tR > N-1 || tC < 0 || tC > M-1 || map[tR][tC] >= 1) continue;
				
				if(map[tR][tC] == 0) {
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				int back = (d + 2) % 4;
				
				rR += dr[back];
				rC += dc[back];
				
				if(map[rR][rC] == 1) break;
			} else {
				d = (d - 1 + 4) % 4;
				
				if(map[rR+dr[d]][rC+dc[d]] == 0) {
					rR += dr[d];
					rC += dc[d];
				}
			}
		}
		
		System.out.println(ans);
		
	}

}
