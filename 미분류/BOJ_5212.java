

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 5212. 지구 온난화
 */
public class BOJ_5212 {
	static int[] dr = {-1,1,0,0}; // 상 하 좌 우
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		char[][] map = new char[A][B]; // 현재 map
		char[][] resmap = new char[A][B]; // 50년 후 map
		
		for(int i=0; i<A; i++) {
			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			String strs = st2.nextToken();
			for(int j=0; j<B; j++) {
				map[i][j] =  strs.charAt(j); // map에 지도 입력
			}
		}
		
		for(int i=0; i<A; i++) {
			for(int j=0; j<B; j++) {
				int cnt=0;
				if(map[i][j] == '.') { // 바다라면 해당되지 않으므로 resmap에 입력 후 pass
					resmap[i][j] = '.';
					continue; 
				}
				
				for(int dir=0; dir<4; dir++) { // 사방탐색
					int nr = i + dr[dir];
					int nc = j + dc[dir];
					
					if(nr >= 0 && nr < A && nc >= 0 && nc < B) { // 맵 범위 안에 있을 때
						if(map[nr][nc] == '.') {
							cnt++;
							continue;
						}
					}else cnt++;
				}
				
				if(cnt >= 3) { // 3면 이상 둘러싸여 있으면 바다로 resmap에 입력
					resmap[i][j] = '.';
				} else { // 그 이하라면 평지로 resmap에 입력
					resmap[i][j] = 'X';
				}
			}
		}
		
		int resr[] = {-1,-1};
		int resc[] = {-1,-1};
		
		for(int i=0; i<A; i++) {
			for(int j=0; j<B; j++) { // 위 -> 아래 행 검사
				if(resmap[i][j] == 'X') {
					resr[0] = i;
				}
			}
			if(resr[0] != -1) break;
		}
		
		for(int i=A-1; i>=0; i--) {
			for(int j=0; j<B; j++) { // 아래 -> 위 행 검사
				if(resmap[i][j] == 'X') {
					resr[1] = i;
				}
			}
			if(resr[1] != -1) break;
		}
		
		for(int i=0; i<B; i++) { // 왼쪽 -> 오른쪽 열 검사
			for(int j=0; j<A; j++) {
				if(resmap[j][i] == 'X') {
					resc[0] = i;
				}
			}
			if(resc[0] != -1) break;
		}
		
		for(int i=B-1; i>=0; i--) { // 오른쪽 -> 왼쪽 열 검사
			for(int j=A-1; j>=0; j--) {
				if(resmap[j][i] == 'X') {
					resc[1] = i;
				}
			}
			if(resc[1] != -1) break;
		}
		
		for(int i=resr[0]; i<=resr[1]; i++) { // 결과값 출력
			for(int j=resc[0]; j<=resc[1]; j++) {
					System.out.print(resmap[i][j]);
			}
			System.out.println();
		}
		

	}

}
