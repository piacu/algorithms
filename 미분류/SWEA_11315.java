

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_11315 {
	static int dr[] = {0,1,1,1}; // 우, 하, 좌하, 우하
	static int dc[] = {1,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			char map[][] = new char[N][N];
			String isYes = "NO";
			
			for(int i=0; i<N; i++) {
				String str = bf.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			L:for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 'o') {
						
						for(int k=0; k<4; k++) {
							int cnt=0;
							int r=i, c=j;
							
							for(int z=0; z<4; z++) { // 5번 찾을때
								
								int nr = r + dr[k];
								int nc = c + dc[k];
								
								if(nr>=0 && nr<N && nc>=0 && nc<N && map[nr][nc] == 'o') {
									cnt++;
									r = nr;
									c = nc;
								}else break;
							
							}
							if(cnt==4) {
								isYes = "YES";
								break L;
							}
							
						}
						
					}
				}
			}
			
			
			System.out.printf("#%d %s\n",tc,isYes);
			
		}
		

	}

//	private static int dfs(int r, int c, int cnt) {
//		if(cnt==5) {
//			return 5;
//		}
//		
//		for(int i=0; i<5; i++) {
//			int nr = r + dr[i];
//			int nc = c + dc[i];
//			
//			for(nr>=0 && nr<N && nc>=0 && nc<N && ) {
//				
//			}
//			
//		}
//		
//	}

}
