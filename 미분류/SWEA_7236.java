

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7236 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		int dr[] = {-1,1,0,0,-1,-1,1,1}; // 상 하 좌 우
		int dc[] = {0,0,-1,1,-1,1,-1,1};
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			char[][] map = new char[N][N];
			int res=1; // 기본 물의 높이
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 'W') { // 현재 위치가 Water 일때(Ground일때는 세줄 필요가 없음)
						int cnt=0;
						for(int k=0; k<8; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];
							
							if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc] == 'W') {
								cnt++;
							}
						}
						res = Math.max(res, cnt);
					}
				}
			}
			
			System.out.printf("#%d %d\n",tc,res);
			
			
		}
		
	}
}
