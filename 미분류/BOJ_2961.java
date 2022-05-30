

import java.util.Scanner;
/*
 * BOJ 2961. 도영이가 만든 맛있는 음식
 */
public class BOJ_2961 {
	static int N, res = 987654321;
	static int[][] food;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 재료의 개수
		
		food = new int[N][2]; // 재료의 신맛과 쓴맛 입력 배열
		
		for(int i=0; i<N; i++) {
			food[i][0] = sc.nextInt();
			food[i][1] = sc.nextInt();
		}
		
		powerSet(0, 0, new boolean[N]);
		
		System.out.println(res);
		sc.close();
	}

	private static void powerSet(int idx, int cnt, boolean[] v) {
	
		if(idx == N) { // 고르는 게 끝났을 때(부분집합 중 하나를 만들었을 때)
			if(cnt == 0) return; // 공집합일 때 return
			int sour=1, bitter=0;
			
			for(int i=0; i<N; i++) {
				if(v[i]) {
					sour *= food[i][0]; //신맛*쓴맛 = 음식의 신 맛
					bitter += food[i][1]; //신맛+쓴맛 = 음식의 쓴 맛
				}
			}
			res = Math.min(Math.abs(sour-bitter), res); // res에 신맛과 쓴맛의 차이가 제일 작은 음식 저장
			return;
		}
		
		v[idx] = true; // idx번째 고름
		powerSet(idx+1, cnt+1, v); // 다른 음식 선택 및 고른 개수 +1
		v[idx] = false; // idx번째 고르지 않고 다음 인덱스 선택
		powerSet(idx+1, cnt, v); // 다른 음식 선택, 고른 개수는 똑같음
	}
	
	

}
