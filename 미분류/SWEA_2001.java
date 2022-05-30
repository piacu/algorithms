

import java.util.Scanner;
import java.io.FileInputStream;

/*
 * SWEA 2001. 파리 퇴치
 */
public class SWEA_2001 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input_2001.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			int res = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();// 영역 입력
				}
			}

			for (int i = 0; i <= N - M; i++) { // 맵 크기 N 에서 파리채 크기 M을 뺼셈해줘서 배열 영역 밖으로 나가지 않도록 함
				for (int j = 0; j <= N - M; j++) {
					int sum = 0;
					for (int r = i; r < M + i; r++) { // 가로세로 M 크기의 파리채로 파리 개수 sum
						for (int c = j; c < M + j; c++) {
							sum += arr[r][c];
						}
					}
					if (res < sum)
						res = sum; // sum이 res(초기값:0)보다 크면 sum 저장
				}
			}

			System.out.println("#" + test_case + " " + res);

		}
		sc.close();
	}
}
