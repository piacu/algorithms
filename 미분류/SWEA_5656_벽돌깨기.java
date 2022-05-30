

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {
	static int N, W, H;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < map[0].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			recursive(0);
			gravity();
			
		}

	}
	
	private static void recursive(int cnt) {
		if(cnt == N) {
			
		}
		
		for(int c=0; c<W; c++) {
			int [][] cpyMap = mapCopy(map);
			
			for(int r=0; r<H; r++) {
				if(cpyMap[r][c] != 0) {
					hitBrick(cpyMap, r, c);
				}
				
			}
		}
	}
	
	private static void hitBrick(int[][] cpyMap, int r, int c) {
		int num = cpyMap[r][c];
		
		
		
	}

	private static int[][] mapCopy(int[][] OrgMap) {
		int[][] newMap = new int[H][W];
		
		for (int i = 0; i < newMap.length; i++) {
			for (int j = 0; j < newMap[0].length; j++) {
				newMap[i][j] = OrgMap[i][j];
			}
		}
		
		return newMap;
	}

	private static void gravity() {
		// TODO Auto-generated method stub
		
	}
	

}
