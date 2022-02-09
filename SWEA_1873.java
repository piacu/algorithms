import java.util.Scanner;

public class SWEA_1873 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		char[] DIR = { '^', 'v', '<', '>' };
		int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
		int[] dy = { 0, 0, -1, 1 };

		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt(); // height
			int W = sc.nextInt(); // width
			char[][] map = new char[H][W];
			int tankX = 0, tankY = 0, dir = 0;
			// tank X위치 tank Y위치 X,Y방향

			for (int i = 0; i < H; i++) {
				String str = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					for (int k = 0; k < DIR.length; k++) {
						if (map[i][j] == DIR[k]) {
							tankX = i;
							tankY = j;
							dir = k;
						}
					}
				}
			}

			int moveNum = sc.nextInt();
			char[] move = new char[moveNum];
			String strm = sc.next();

			for (int i = 0; i < moveNum; i++) {
				move[i] = strm.charAt(i);
			}

			for (int k = 0; k < moveNum; k++) {

				if (move[k] == 'U') dir = 0;
				else if (move[k] == 'D') dir = 1;
				else if (move[k] == 'L') dir = 2;
				else if (move[k] == 'R') dir = 3;

				int nx = tankX + dx[dir];
				int ny = tankY + dy[dir];

				if (move[k] == 'S') {
					int nxx = nx;
					int nyy = ny;
					while (nxx >= 0 && nxx < H && nyy >= 0 && nyy < W) {
						if (map[nxx][nyy] == '*') {
							map[nxx][nyy] = '.';
							break;
						} else if (map[nxx][nyy] == '#') {
							break;
						}
						nxx += dx[dir];
						nyy += dy[dir];
					}

				} else if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
					if(map[nx][ny] == '.'){
						map[tankX][tankY] = '.';
						tankX = nx;
						tankY = ny;
					}
				}

				map[tankX][tankY] = DIR[dir];

			}

			System.out.print("#"+tc+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}

		sc.close();
	}

}