import java.util.Scanner;

public class BOJ_1238 {
	static int[][] road;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();
		road = new int[M][3];
		
		for(int i=0; i<M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int weight = sc.nextInt();
			
			road[r][c] = weight;
		}
		
		for(int i=0; i<N; i++) {
			dfs(i, X, new boolean[M][3]);
		}
		sc.close();
	}
	private static void dfs(int now, int dest, boolean[][] v) {
		
		
		for(int i=0; i<road[0].length; i++) {
			
			
		}
		
	}

}
