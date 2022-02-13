import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * SWEA 1206. [S/W 문제해결 기본] 1일차 - View
 */
public class SWEA_1206 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_SWEA1206.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int T = Integer.parseInt(bf.readLine());
			int[] apt = new int[T+4];
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			for(int i=0; i<T; i++) {
				apt[i] = Integer.parseInt(st.nextToken());
			}
			
			int res = 0;
			
			for(int i=2; i<T-2; i++) { // 테스트케이스에서 첫번째 두 케이스와 마지막 두 케이스는 0이므로 제외
				int left = Math.min(apt[i] - apt[i-2], apt[i] - apt[i-1]); // <왼쪽>은 빌딩의 왼쪽 두 칸 중 적은 숫자의 조망권 확보가능
				int right = Math.min(apt[i] - apt[i+2], apt[i] - apt[i+1]); // <오른쪽>은 빌딩의 오른쪽 두 칸 중 중 적은 숫자의 조망권 확보가능
				
				int sum = Math.min(left, right); // <왼쪽>과 <오른쪽> 중 적은 수의 조망권 확보
				
				if(sum > 0) {
					res += sum;
				}
				
			}
			
			System.out.println("#"+tc+" "+res);
		}
		
	}

}