

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4613 {
	static int N, M, res;
	static int[][] words;
	static boolean[][] v;
	static int[] dr = {1,1};
	static int[] dc = {0,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_SWEA4613.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			res = Integer.MAX_VALUE;
			
			words = new int[N][3];
			
			
			for(int i=0; i<N; i++) {
				String str = bf.readLine();
				for(int j=0; j<M; j++) {
					char ch = str.charAt(j);
					if(ch=='W')
						words[i][0]++;
					else if(ch=='B')
						words[i][1]++;
					else if(ch=='R')
						words[i][2]++;
				}
			}
			
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<3; j++) {
					System.out.print(words[i][j]+" ");
				}
				System.out.println();
			}
			
			
			v = new boolean[N][3];
			dfs(0,0,0);
			
			System.out.printf("#%d %d\n",tc,res);
			
		}

	}
	private static void dfs(int r, int c, int sum) {
		if(r==N-1 && c==M-1) {
			res = Math.min(sum, res);
			return;
		}
		
		v[r][c] = true;
		
		for(int i=0; i<2; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M) {
				sum += words[nr][nc];
				dfs(nr,nc,sum);
			}
		}
		
	}

//	private static int bfs(int r, int c) {
//		Queue<Integer> q = new LinkedList<>();
//		q.add(words[r][c]);
//		v[r][c] = true;
//		int end=0;
//		
//		while(!q.isEmpty()) {
//			int p = q.poll();
//			
//			for(int i=0; i<words[0].length; i++) {
//				
//			}
//			
//			
//		}
//		
//		return end;
//	}

}
