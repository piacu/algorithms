

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {
	static int tasun, Ans;
	static int[][] gameInput;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		gameInput = new int[T][9];
		
		for (int i = 0; i < gameInput.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < gameInput[0].length; j++) {
				gameInput[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		permutation_sunsu(1, new boolean[9], new int[9]);
		
		System.out.println(Ans);
	}
	
	// 첫 번째 인원을 무조건 4번 타자로 하는 순열
	private static void permutation_sunsu(int cnt, boolean[] visited, int[] resArr) {
		if(cnt == 9) {
			//System.out.println(Arrays.toString(resArr));
			baseballGame(resArr);
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(i==3) continue;
			if(!visited[i]) {
				
				visited[i] = true;
				
				resArr[i] = cnt;
				permutation_sunsu(cnt+1, visited, resArr);
				visited[i] = false;
			}
			
		}
	}
	
	private static void baseballGame(int[] sunsu) {
		int score = 0;
		tasun = 0;
		
		for (int i = 0; i < gameInput.length; i++) {
			int out = 0;
			int[] ru = new int[4];
			while(out < 3) { // 아웃 세번이면 다음 게임 진행
					int res = gameInput[i][sunsu[tasun]];
					
					if(res == 4) {
						score += ru[3] + ru[2] + ru[1] + 1;
						ru[3] = ru[2] = ru[1] = 0;
					} else if(res == 3) {
						score += ru[3] + ru[2] + ru[1];
						ru[3] = 1; 
						ru[2] = ru[1] = 0;
					} else if(res == 2) {
						score += ru[3] + ru[2];
						ru[3] = ru[1];
						ru[2] = 1;
						ru[1] = 0;
					} else if(res == 1) {
						score += ru[3];
						ru[3] = ru[2];
						ru[2] = ru[1];
						ru[1] = 1;
					} else out++;
					
					tasun = ++tasun % 9;
			}
			
		}
		Ans = Math.max(Ans, score);
	}
}
