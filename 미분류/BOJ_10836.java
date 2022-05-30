import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10836 {
	static int[] dr = { -1, -1, 0 };
	static int[] dc = { -1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] days = new int[N][3];

		// 자라는 정도를 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			days[i][0] = Integer.parseInt(st.nextToken());
			days[i][1] = Integer.parseInt(st.nextToken());
			days[i][2] = Integer.parseInt(st.nextToken());
		}

		int[][] map = new int[M][M];

		int round = 0;

		while (round < N) {
			int[] day = new int[] { days[round][0], days[round][1], days[round][2] };

			int nx = M - 1, ny = 0;
			for (int z = 0; z < 2 * M - 1; z++) {

				int grow = 0;

				for (int i = 0; i < 3; i++) {
					if (day[i] > 0) {
						grow = i;
						day[i] -= 1;
						break;
					}
				}

//				System.out.println(Arrays.toString(day));
//				System.out.println("GROW : "+grow);

				if (z < M - 1) {
					map[nx--][0] += grow;
				} else {
					map[0][ny++] += grow;
				}

//				print(map);
			}

			round++;
		}

		for (int i = 1; i < M; i++) {
			for (int j = 1; j < M; j++) {
				map[j][i] = map[0][i];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++)
				sb.append((map[i][j]+1) + " ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print((map[i][j] + 1) + " ");
			}
			System.out.println();
		}

	}

}
