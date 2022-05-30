

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_2112_보호필름 {
	static int[][] film;
	static int D, W, K;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/algo_0405/input_SWEA2112.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			D = sc.nextInt(); // 두께
			W = sc.nextInt(); // 셀 개수
			K = sc.nextInt(); // 합격기준
			
			film = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt(); // A=0 | B=1
				}
			}
			
			
			film_powerSet(0, new boolean[D]);
			System.out.println(check());
			
			
			
			System.out.printf("#%d %d\n",tc,0);
		}
		
		sc.close();
	}
	private static void film_powerSet(int k, boolean[] sel) {
		if(k == sel.length) {
			for(int i=0; i<sel.length; i++) {
				if(sel[i]) {
					
				}
			}
			return;
		}
		
		sel[k] = false;
		film_powerSet(k+1, sel);
		sel[k] = true;
		film_powerSet(k+1, sel);
		
	}
	
	private static boolean process(int row, int useCnt) {
		if(row == D) {
			if(check()) {
				min = Math.min(min, useCnt);
			}
			return;
		}
		
		if(useCnt >= min) return;
		
		
		int[] backup; // 현재 막의 상태 기억
		
		// 약품 비투여
		process(row+1, useCnt);
		
		// 약품A 투여
		film[row] = drugA;
		process(row+1, useCnt+1);
		
		// 약품B 투여
		film[row] = drugB;
		process(row+1, useCnt+1);
		
		film[row] = backup;
	}
	
	private static boolean check() {
		int chkResult=0;
		
		for(int i=0; i<film[0].length; i++) {
			int tmpA=0, tmpB=0;
			for (int j = 0; j < film.length; j++) {
				if(film[j][i]==0) {
					tmpA++;
					tmpB=0;
				}
				else if(film[j][i]==1) {
					tmpB++;
					tmpA=0;
				}
				if(tmpA>=K || tmpB>=K) {
					chkResult++;
					break;
				}
			}
		}
		
		if(chkResult == W) return true;
		
		return false;
	}

}
