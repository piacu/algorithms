import java.io.FileInputStream;
import java.util.Scanner;
/*
 * SWEA 1209. [S/W 문제해결 기본] 2일차 - Sum
 */
public class SWEA_1209 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input_SWEA1209.txt"));
		Scanner sc = new Scanner(System.in);
		for(int test_case=1; test_case<=10; test_case++) {
			int tc = sc.nextInt(); // 미사용
			int[][] map = new int[100][100];
			int max=0;
			
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<100; i++) {
				int sumX=0, sumY=0;
				for(int j=0; j<100; j++) {
					sumX += map[i][j]; // i행 덧셈
					sumY += map[j][i]; // i열 덧셈
				}
				if(max < sumX) max = sumX; // 최대값 저장
				if(max < sumY) max = sumY;
			}
			
			int sumZ1=0, sumZ2=0;
			
			for(int i=0; i<100; i++) {
				sumZ1 += map[i][i]; // 왼쪽 위에서 시작하는 대각선 덧셈
				sumZ2 += map[99-i][i]; // 오른쪽 위에서 시작하는 대각선 덧셈
			}
			
			if(max < sumZ1) max = sumZ1; // 최대값 저장
			if(max < sumZ2) max = sumZ2;
			
			System.out.println("#"+test_case+" "+max);
		}
		sc.close();
		
	}
}
