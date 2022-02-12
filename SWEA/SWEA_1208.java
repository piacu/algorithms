import java.io.FileInputStream;
import java.util.Scanner;
/*
 * SWEA 1208. [S/W 문제해결 기본] 1일차 - Flatten
 */
public class SWEA_1208 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_SWEA1208.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int dump = sc.nextInt();
			int[] map = new int[100];
			
			for(int i=0; i<100; i++) {
				map[i] = sc.nextInt();
			}
			
			int maxi=0, mini=0;
			
			for(int i=0; i<dump; i++) {
				int max=1, min=100; // 대소 비교를 위해 max는 최저값, min은 최고값을 저장
				for(int j=0; j<100; j++) {
					if(map[j] > max) {	max = map[j]; maxi=j;	} // 최고값을 max에 저장, 위치는 maxi에 입력
					if(map[j] < min) {	min = map[j]; mini=j;	} // 최저값을 min에 저장, 위치는 mini에 입력
				}
				map[maxi]--; // 최고 높이의 블럭을 하나 줄이고
				map[mini]++; // 최저 높이의 블럭을 하나 늘림
			}
			
			int max2=1, min2=100;
			for(int i=0; i<100; i++) {
				if(max2 < map[i]) max2 = map[i]; // 덤프 이후 최고점
				if(min2 > map[i]) min2 = map[i]; // 덤프 이후 최저점
			}
			
			System.out.println("#"+test_case+" "+(max2-min2));
			
		}
		sc.close();
	}
}
