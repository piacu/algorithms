

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157 {
	static int[] dr = {0,1,0,-1}; // 우 하 좌 상
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int R = Integer.parseInt(st.nextToken()) + 1;
		int C = Integer.parseInt(st.nextToken()) + 1;
		int K = Integer.parseInt(bf.readLine());
		int dir=0, num=1;
		
		int[][] map = new int[R][C];
		int r=1, c=1, cnt=0;
		map[1][1] = 1;
		
		if(K==1) {
			System.out.println("1 1");
			return;
		}
		if(K>R*C) {
			System.out.println(0);
			return;
		}
		
		while(cnt!=R*C) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(nr>=1 && nr<R && nc>=1 && nc<C && map[nr][nc]==0) {
				map[nr][nc] = ++num;
				r = nr; c = nc;
				
			} else {
				dir = (dir+1)%4;
			}

			
			if(map[r][c] == K) {
				System.out.println(r+" "+c);
				return;
			}
			++cnt;
		}
		

	}

}
