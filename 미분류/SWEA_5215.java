

import java.util.Scanner;
/*
 * SWEA 5215. 햄버거 다이어트
 */
public class SWEA_5215 {
	static int N, R;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<T; tc++) {
			int N = sc.nextInt(); // 재료의 수
			int L = sc.nextInt(); // 칼로리 제한
			int[][] food = new int[N][2];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<2; j++) {
					food[i][j] = sc.nextInt();
				}
			}
			
			CalorieCalc(food, 0,0,L,0);
			
			
		}
		sc.close();
	}
	
	static void CalorieCalc(int[][] food, int L, int res) {
		int cal=0;
		int taste=0;
		
		if(cal < L) {
			res = Math.max(res, taste);
		}
		
		
		for(int i=0; i<food.length; i++) {
			cal += food[i][1];
			taste += food[i][0];
			CalorieCalc(food, L, res);
		}
		
	}
}
