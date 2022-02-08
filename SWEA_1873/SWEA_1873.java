import java.io.FileInputStream;
import java.util.Scanner;
/*
 * SWEA 1873. 상호의 배틀필드
 */
public class SWEA_1873 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/input_1873.txt"));
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
					map[i][j] = str.charAt(j); // 맵 설정
					for (int k = 0; k < DIR.length; k++) {
						if (map[i][j] == DIR[k]) { // 전차 위치 찾으면
							tankX = i; // x위치
							tankY = j; // y위치
							dir = k; // 전차가 바라보는 방향
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

				if (move[k] == 'U') dir = 0; // U,D,L,R 일때 방향 각각 상,하,좌,우로 변경
				else if (move[k] == 'D') dir = 1;
				else if (move[k] == 'L') dir = 2;
				else if (move[k] == 'R') dir = 3;

				int nx = tankX + dx[dir];
				int ny = tankY + dy[dir];

				if (move[k] == 'S') { // Shoot
					int nxx = nx;
					int nyy = ny;
					while (nxx >= 0 && nxx < H && nyy >= 0 && nyy < W) { // 포탄이 현재 전차 방향 직진으로 이동, 맵을 벗어나면 사라짐
						if (map[nxx][nyy] == '*') { // 벽돌을 만나게 되면 부숨
							map[nxx][nyy] = '.';
							break;
						} else if (map[nxx][nyy] == '#') { // 강철을 만나면 break
							break;
						}
						nxx += dx[dir]; // 포탄의 위치 1칸 이동
						nyy += dy[dir];
					}

				} else if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
					if(map[nx][ny] == '.'){ // 이동하는 방향이 평지라면
						map[tankX][tankY] = '.'; // 전차가 있는 위치를 평지로 변경
						tankX = nx; // 전차 이동
						tankY = ny;
					}
				}

				map[tankX][tankY] = DIR[dir]; // 맵에 전차 위치 및 방향 표시

			}

			System.out.print("#"+tc+" "); // 출력문
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