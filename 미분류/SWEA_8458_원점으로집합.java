

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8458_원점으로집합 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			Point[] p = new Point[N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				p[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			boolean isOdd = false, isEven = false;
			
			for(int i=0; i<N; i++) {
				int sum = p[i].r + p[i].c;
				
				if(Math.abs(sum) % 2 == 1) isOdd = true;
				else isEven = true;
			}
			
			if(isOdd == isEven) {
				System.out.printf("#%d -1\n", tc);
				continue;
			}
			
			int move = 0;
			boolean flag = false;
			while (true) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < move; j++) {
						int r = p[i].r;
						int c = p[i].c;

						if (r > 0) {
							r--;
						} else if (r < 0) {
							r++;
						} else if (c > 0) {
							c--;
						} else if (c < 0) {
							c++;
						}
						
						
						p[i].r = r;
						p[i].c = c;
					}

				}

				for (int i = 0; i < N; i++) {
					if (p[i].r == 0 && p[i].c == 0) {
						flag = true;
					}
					else {
						flag = false;
						break;
					}
				}

				if (flag)
					break;
				move++;
			}

			System.out.printf("#%d %d\n", tc, move);
		}

	}

}
