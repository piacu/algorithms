

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012 {
	static int res;
	static int[][] fmap;
	static boolean[][] isSel;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc < T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			
			res=0;
			fmap = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					fmap[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			
			
			
			
			
			System.out.println("#"+tc+" "+res);
		}
	}

}
