

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {
	static int N;
	static int[][] home;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		home = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			
			home[a][b] = price;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(home[i][k] + home[i][k] < home[i][j]) {
						
					}
				}
			}
		}
		
		powerset_home(0, N, new boolean[N+1]);
		
	//print(home);	

	}
	
	private static void powerset_home(int idx, int k, boolean[] v) {
		if(idx == k) {
			for(int i=0; i<k; i++) {
				if(v[i])
					System.out.print((i+1)+" ");
			}
			System.out.println();
			return;
		}
		
		v[idx] = true;
		powerset_home(idx+1, k, v);
		
		v[idx] = false;
		powerset_home(idx+1, k, v);
		
	}
	
	private static void print(int[][] h) {
		for (int i = 0; i < h.length; i++) {
			for (int j = 0; j < h.length; j++) {
				System.out.print(h[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	

}
