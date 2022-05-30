

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992 {
	static int[][] map;
	static int size;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		size = N;
		
		
		for(int i=0; i<N; i++) {
			String str = bf.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		quadTree(0, 0, size);
		
		System.out.println(sb);
	}
	
	//dfs
	private static void quadTree(int r, int c, int size) {
//		if(size == 1) {
//			System.out.print(map[r][c]);
//			return;
//		}
		
		int temp = map[r][c];
		boolean isSame = true;
		
		B:for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(map[i][j] != temp) {
					isSame = false;
					break B;
				}
			}
		}
		
		if(!isSame) {
			sb.append("(");
			quadTree(r, c, size/2);
			quadTree(r, c+size/2, size/2);
			quadTree(r+size/2, c, size/2);
			quadTree(r+size/2, c+size/2, size/2);		
			sb.append(")");
		} else {
			sb.append(temp);
		}
		
	}
}