

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {
	static class Blank {
		int r;
		int c;

		public Blank(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static final int N = 9;
	static boolean flag=false;
	static List<Blank> bs;
	//static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[N][N];
		bs = new ArrayList<>();

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					bs.add(new Blank(i, j));
			}
		}

		backTracking(map, 0);
		
		bf.close();
	}

	private static void backTracking(int[][] map, int cnt) {
		if (cnt == bs.size()) {
			flag = true;
			print(map);
			return;
		}

		//for (int i = 0; i < bs.size(); i++) {
			for (int num = 1; num <= 9; num++) {
				if (!flag && checkRC(map, bs.get(cnt).r, bs.get(cnt).c, num) && checkSQRE(map, bs.get(cnt).r, bs.get(cnt).c, num)) {
					
					map[bs.get(cnt).r][bs.get(cnt).c] = num;
					
					backTracking(map, cnt + 1);
					map[bs.get(cnt).r][bs.get(cnt).c] = 0;

				}
			}
		//}

	}

	private static boolean checkRC(int[][] map, int r, int c, int chk) {
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == chk || map[i][c] == chk) // 동일한 수가 있으면 false 반환(안됨)
				return false;
		}

		return true; // 동일한 수가 없음녀 true 반환
	}

	private static boolean checkSQRE(int[][] map, int r, int c, int chk) {
		int rloc = r / 3, cloc = c / 3;

		for (int i = 3 * rloc; i < 3 * rloc + 3; i++) {
			for (int j = 3 * cloc; j < 3 * cloc + 3; j++) {
				if (map[i][j] == chk)
					return false;
			}
		}
		return true;
	}

	private static void print(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}

	}
}
