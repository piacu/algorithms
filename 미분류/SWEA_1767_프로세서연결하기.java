

import java.util.Scanner;

public class SWEA_1767_프로세서연결하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[][] adj = new int[N][N];
			
			for (int i = 0; i < adj.length; i++) {
				for (int j = 0; j < adj[0].length; j++) {
					adj[i][j] = sc.nextInt();
				}
			}
			
			for(int i=1; i<N-1; i++) {
				for(int j=1; j<N-1; j++) {
					for(int d=0; d<4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if(nr>=1 && nr<N-1 && nc>=1 && nc<N-1) {
							
						}
						
					}
				}
			}
			
			
			
			System.out.println();
		}
		
		sc.close();
	}

}
