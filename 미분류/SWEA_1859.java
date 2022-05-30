

import java.util.Scanner;

public class SWEA_1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] price = new int[N];
			long res = 0;
			
			for(int i=0; i<N; i++) {
				price[i] = sc.nextInt();
			}
	
			
			int tmp = price[N-1]; // tmp는 마지막 값 저장
			
			for(int i=N-1; i>0; i--) { // 뒤에서부터 계산
				if(price[i-1] > tmp) { // 이전 값이 tmp보다 크면(여기에 팔아야 이익이니)
					tmp = price[i-1]; // tmp를 바꿔줌
					continue; // 작은 수에서 큰 수를 빼면 안되니까 continue
				}
				res += tmp - price[i-1]; // 값 더하기
			}
			
			System.out.printf("#%d %d\n",tc,res);
		}

	}

}
