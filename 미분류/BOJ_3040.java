

import java.util.Scanner;

public class BOJ_3040 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			
		}
		
		powerSet(0, 0, new boolean[9]);

		sc.close();
	}
	private static void powerSet(int idx, int cnt, boolean[] v) {
		if(idx == arr.length) {
			if(cnt == 7) {
				int sum=0;
				for(int i=0; i<arr.length; i++) {
					if(v[i]) {
						sum += arr[i];
					}
				}
				if(sum == 100) {
					for(int i=0; i<arr.length; i++) {
						if(v[i]) {
							System.out.println(arr[i]);
						}
					}
				}
				
			}
			return;
		}
		
		v[idx] = true;
		powerSet(idx+1, cnt+1, v);
		v[idx] = false;
		powerSet(idx+1, cnt, v);
		
	}

}
