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

			for (int i = 0; i < H; i++) { // map 입력
				String str = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					for (int k = 0; k < DIR.length; k++) {
						if (map[i][j] == DIR[k]) { // 전차 X,Y위치 입력 및 방향 입력
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

				if (move[k] == 'U') dir = 0; // U 일때 위 방향
				else if (move[k] == 'D') dir = 1; // D 일때 아래 방향
				else if (move[k] == 'L') dir = 2; // L 일때 왼쪽 방향
				else if (move[k] == 'R') dir = 3; // R 일때 오른쪽 방향

				int nx = tankX + dx[dir];
				int ny = tankY + dy[dir];

				if (move[k] == 'S') { // Shoot 명령이 들어오면
					int nxx = nx;
					int nyy = ny;
					while (nxx >= 0 && nxx < H && nyy >= 0 && nyy < W) { //맵 벗어날 시에 종료
						if (map[nxx][nyy] == '*') { // 벽돌일 때 부수고 평지로 만듦
							map[nxx][nyy] = '.';
							break;
						} else if (map[nxx][nyy] == '#') { // 강철일 때는 아무 일도 없음
							break;
						}
						nxx += dx[dir];
						nyy += dy[dir];
					}

				} else if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
					if(map[nx][ny] == '.'){ // 전차 이동 시키고 전차가 있던 자리는 평지로 변경
						map[tankX][tankY] = '.';
						tankX = nx;
						tankY = ny;
					}
				}

				map[tankX][tankY] = DIR[dir]; //맵에 전차 아이콘 표시

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