import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이_되고픈_원숭이 {
	static class Monkey {
		int r;
		int c;
		int k;
		int cnt;
		
		Monkey(int r, int c, int k, int cnt){
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
	}
	static int R, C, RES;
	static int[][] MAP;
	static boolean[][][] VISITED;
	// 말처럼 이동
	static int[] HDR = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] HDC = {-2, -1,  1,  2, 2, 1,-1,-2};
	// 원숭이처럼 이동
	static int[] DR = {0, -1, 0, 1};
	static int[] DC = {-1, 0, 1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		MAP = new int[R][C];
		VISITED = new boolean[k+1][R][C];
		
		for(int i=0; i<MAP.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<MAP[0].length; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		RES = Integer.MAX_VALUE;		
		monkeyBfs(0, 0, k);
		
		System.out.println(RES != Integer.MAX_VALUE ? RES : -1);
	}
	
	private static void monkeyBfs(int sr, int sc, int sk) {
		Queue<Monkey> q = new LinkedList<>();
		q.add(new Monkey(sr, sc, sk, 0));
		VISITED[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Monkey curM = q.poll();
			
			if(curM.r == R-1 && curM.c  == C-1) {
				RES = Math.min(RES, curM.cnt);
			}
			
			for(int i=0; i<4; i++) {
				int nr = curM.r + DR[i];
				int nc = curM.c + DC[i];
				
				if(nr>=0 && nr<MAP.length && nc>=0 && nc<MAP[0].length && MAP[nr][nc] == 0 && !VISITED[curM.k][nr][nc]) {
					VISITED[curM.k][nr][nc] = true;
					q.add(new Monkey(nr, nc, curM.k, curM.cnt+1));
				}
			}
			
			if(curM.k > 0) {
				for(int i=0; i<8; i++) {
					int nr = curM.r + HDR[i];
					int nc = curM.c + HDC[i];
					
					if(nr>=0 && nr<MAP.length && nc>=0 && nc<MAP[0].length && MAP[nr][nc] == 0 && !VISITED[curM.k-1][nr][nc]) {
						VISITED[curM.k-1][nr][nc] = true;
						q.add(new Monkey(nr, nc, curM.k-1, curM.cnt+1));
					}
				}				
			}
			
		}
		
	}
}