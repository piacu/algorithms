

import java.io.FileInputStream;
import java.util.Scanner;
/*
 * SWEA 1244. [S/W 문제해결 응용] 2일차 - 최대 상금
 */
public class SWEA_1244 {
	static int[] number;
	static int res;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input_SWEA1244.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			String str = sc.next();
			int changes = sc.nextInt(); // 바꿀수 있는 수의 개수

			number = new int[str.length()];
			
			for(int i=0; i<str.length(); i++) {
				number[i] = str.charAt(i) - '0';
			}
			
			for(int i=0; i<changes; i++) {
				comb(0, 0, new boolean[str.length()]);
			}
			
			System.out.println(str);
			
			
		}
		
	}
	private static void comb(int cnt, int idx, boolean[] v) {
		
		if(cnt == number.length) { 
			for(int i=0; i<number.length; i++)
				System.out.print(number[i]+" ");
			System.out.println();
			return;
		}
		
		for(int i=idx; i<number.length; i++) {
			if(number[cnt] > number[i]) {
				int tmp = number[cnt];
				number[cnt] = number[i];
				number[i] = tmp;
			}
				//number[cnt] = number[i];
			
			comb(cnt+1, i+1, v);
			
		}
		
	}
	
	
	
	
	
//	private static void perm(int cnt, int idx, boolean[] v, int change) {
//		if(cnt == number.length) { // base part
//			String tmpStr="";
//			for(int i=0; i<number.length; i++) {
//				tmpStr += Integer.toString(number[i]);
//			}
//			int tmpInt = Integer.parseInt(tmpStr);
//			res = Math.max(tmpInt, res);
//			return;
//		}
//		
//		// inductive part
//		for(int i=idx; i<number.length; i++) {
//			if(v[i]) continue;
//			
//			v[i] = true;
//			perm(cnt+1, idx+1, v, change);
//			v[i] = false;
//		}
//		
//	}

}
