import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2583 {
	static int M, N, cnt=1;
	static int map[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		int area=0;
		
		for(int ks=0; ks<K; ks++) {
			st = new StringTokenizer(bf.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i=x1; i<x2; i++) {
				for(int j=y1; j<y2; j++) {
					map[i][j] =  9;
				}
			}
		}
		
		List<Integer> arr = new ArrayList<>(); 
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(map[i][j] == 0) {
					area++;
					dfs(i, j);
					arr.add(cnt);
					cnt=1;
				}
			}
		}

		Collections.sort(arr);
		//print();
		System.out.println(area);
		for (Integer a : arr) {
			System.out.print(a+" ");
		}
	}
	
	private static void dfs(int r, int c) {
		
		map[r][c] = cnt;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc] == 0) {
				cnt++;
				dfs(nr, nc);
			}
		}
		
	}
	private static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
