

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {
	static int res = 9999;
	static int[][] map;
	static int[][] calc;
	static int dr[] = {1,0,-1,0}; // 하 우 상 좌
	static int dc[] = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_BOJ17406.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		calc = new int[K][3];
		
		for(int i=1; i<=N; i++) { // 배열 값 입력
			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			for(int j=1; j<=M; j++) {
				 map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		for(int i=0; i<K; i++) { // 회전 연산 정보 입력
			StringTokenizer st3 = new StringTokenizer(bf.readLine());
			for(int j=0; j<3; j++) {
				 calc[i][j] = Integer.parseInt(st3.nextToken());
			}
		}
		
		//permutation(calc);
		int rmap[][] = map;
		rotate(rmap, 3,4,2);
		
		//resArr(map);
		
		//System.out.println(res);
	}

	private static void rotate(int[][] rmap, int r, int c, int s) {
		int dir=0;
		r -=1; c-=1;
		
		int tmp = map[r][c];
		
		while(dir<4) {
			int nr = r-s + dr[dir];
			int nc = c-s + dc[dir];
			
			if(nr>=r-s && nr<r+s && nc>=c-s && nc<c+s) {
				rmap[nr][nc] = map[r][c];
				r = nr; c = nc;
			}else dir++;
			
		}
		
		rmap[r][c+1] = tmp;
		
		for(int i=0; i<rmap.length; i++) {
			for(int j=0; j<rmap[0].length; j++) {
				System.out.print(rmap[i][j]+ " ");
			}
			System.out.println();
		}
	}
		

	private static void permutation(int[][] calc) {
		// TODO Auto-generated method stub
		
	}

	private static void resArr(int[][] arr) {
		int plus = 0;
		for(int i=1; i<=arr.length; i++) {
			for(int j=1; j<=arr[0].length; i++) {
				plus += arr[i][j];
			}
			if(plus < res) res = plus;
		}
	}
	

}
