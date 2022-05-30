import java.io.FileInputStream;
import java.util.Scanner;
/*
 * SWEA 1954. 달팽이 숫자
 */
public class SWEA_1954 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/input_SWEA1954.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] row = { 0, 1, 0, -1 }; // 우 하 좌 상 (돌아야 하는 방향 순서)
		int[] col = { 1, 0, -1, 0 };

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			int x=0, y=0;
			int number = 1;
			int dir = 0;

			while (number <= N*N) {
				int nr = x + row[dir];
				int nc = y + col[dir];
				
				if(nr >= N || nr < 0 || nc >= N || nc < 0 || snail[nr][nc] != 0) { // 맵의 범위에서 벗어날 시
					dir = (dir + 1) % 4; // 방향 변경
					nr = x + row[dir]; nc = y + col[dir]; // 방향변경 후 시작점 지정
				}
				
				snail[x][y] = number++; // 숫자 입력
				
				x = nr; y = nc;
			}
			System.out.println("#"+tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}

		}

		sc.close();
	}
}
