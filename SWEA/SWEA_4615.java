import java.io.FileInputStream;
import java.util.Scanner;
/*
 * SWEA 4615. 재미있는 오셀로 게임
 */
public class SWEA_4615 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/algorithm/input_SWEA4615.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[] dr = { 0, 0, 1, -1, 1, 1, -1, -1 };
		int[] dc = { 1, -1, 0, 0, 1, -1, 1, -1 };
		// 동 서 남 북 남동 남서 북동 북서

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 한 변의 수
			int M = sc.nextInt(); // 돌을 놓는 횟수
			int[][] map = new int[N][N];
			int[] res = new int[3];

			map[N / 2 - 1][N / 2 - 1] = 2; // map 중앙에 돌 기본 배치
			map[N / 2][N / 2 - 1] = 1;
			map[N / 2 - 1][N / 2] = 1;
			map[N / 2][N / 2] = 2;

			for (int num = 0; num < M; num++) {
				int c = sc.nextInt() - 1; // 테스트 케이스는 인덱스 1부터 시작하기 때문에 1 뺄셈해서 입력, column row 순으로 입력됨
				int r = sc.nextInt() - 1; // 테스트 케이스는 인덱스 1부터 시작하기 때문에 1 뺄셈해서 입력
				int or = r; // r의 원래 위치
				int oc = c; // c의 원래 위치

				int bORw = sc.nextInt(); // 흑돌 : 1 / 백돌 : 2

				map[r][c] = bORw;

				for (int i = 0; i < 8; i++) {
					int cnt = 0;
					r = or; // 한 방향 탐색이 끝났으니 r값 원래 값으로 초기화
					c = oc; // 한 방향 탐색이 끝났으니 c값 원래 값으로 초기화
					while (true) {
						int row = r + dr[i];
						int col = c + dc[i];

						if (row >= 0 && row < N && col >= 0 && col < N) { // 맵 범위 안에 있을 때
							if (map[row][col] != 0 && map[row][col] != bORw) { // 0(빈칸)이 아니면서 다른 색 돌일 때 카운트 증가
								cnt++;
							} else if (map[row][col] == bORw) { // 같은 돌을 만났을 시
								for (int k = 1; k <= cnt; k++) {
									map[or + dr[i] * k][oc + dc[i] * k] = bORw; // 바둑돌을 놓은 위치에서 탐색한 곳까지 가는 길의 모든 돌 색상 변경
								}
								break; // 색상 변경 후 break

							} else
								break; // map[row][col]이 0이라면 빈칸이므로 break
						} else
							break; // 맵 범위를 벗어나면 break

						r = row; // row 한칸 이동
						c = col; // col 한칸 이동

					}

				}

			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					res[map[i][j]]++; // res 배열에 돌 개수 추가 (res[1]에 흑돌 개수, res[2]에 백돌 개수)
				}
			}
			System.out.println("#" + test_case + " " + res[1] + " " + res[2]);

		}

	}
}
