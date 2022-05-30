

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * SWEA 1861. 정사각형 방
 */
public class SWEA_1861 {
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	static int[] dl = { 0, 0, -1, 1 };
	static int cnt = 1;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_SWEA1861.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			map = new int[N][N];
			int res = 1000, big=0; // res: 최대 개수의 시작 수 / big: 이어지는 수의 최대 길이

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					findRoom(i,j, 0);
					if(big < cnt) { // 최대로 이어지는 개수가 기존 최대 개수보다 많을 시
						big = cnt; 
						res = map[i][j]; // 시작하는 수 저장
					}else if(big == cnt) { // 최대로 이어지는 개수가 이전과 동일할 시
						if(res > map[i][j]) // 최솟값으로 저장
							res = map[i][j]; 
					}
					cnt=1; // 개수 초기화
				}
			}
			
			System.out.println("#"+tc+" "+res+" "+big);
			
		}

	}

	private static void findRoom(int i, int j, int idx) {
		if (idx == 4) // 사방탐색 완료 시 return
			return;

		int nr = i + dr[idx]; // 기존의 위치에서 상,하,좌,우 방향 탐색
		int nl = j + dl[idx];

		if (nr >= 0 && nr < map.length && nl >= 0 && nl < map.length) { // 범위를 벗어나지 않을 시
			if (map[i][j] + 1 == map[nr][nl]) { // 근접한 위치의 숫자가 기존 위치보다 1 클때
				cnt++; // 갯수 증가
				findRoom(nr, nl, 0); // 이어지는 수의 위치로 이동
			}
		}
		
		findRoom(i, j, idx+1); // 인덱스(탐색 방향) 변경

	}

}