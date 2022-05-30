

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307_최장증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			int nums[] = new int[N+1];
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int i=1; i<=N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			LIS_dp(0, nums, new int[N+1]);
			
			
			
			
		}
	}

	private static void LIS_dp(int[] nums, int[] dp) {
		
		
	}
}
