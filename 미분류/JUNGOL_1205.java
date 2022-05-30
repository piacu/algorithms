

import java.util.Arrays;
import java.util.Scanner;

public class JUNGOL_1205 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] arr = new int[T];
		int joker = 0; // 조커 개수
		int res = 1; // 결과값

		for (int i = 0; i < T; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] == 0)
				joker++;
		}

		Arrays.sort(arr);
		
		System.out.println("joker : "+joker);
		System.out.println(Arrays.toString(arr));

//		for (int i = joker; i < T; i++) {
//			int now = i;
//			int num = arr[now];
//			int jo = joker;
//			int cnt = 0;
//			
//			while(true) {
//				
//				if(now == T) {
//					cnt += jo;
//					break;
//				}
//				//System.out.println("num : "+num+" jo : "+jo+" now : "+now);
//				if(arr[now] == num) {
//					now++;
//				} else {
//					if(--jo < 0) break;
//				}
//				
//				num++;
//				cnt++;
//			}
//			
//			res = Math.max(res, cnt);
//		}
//		
//		if(joker == T) {
//			res = joker;
//		}
		
		System.out.println(res);

	}
}
