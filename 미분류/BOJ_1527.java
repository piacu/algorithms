

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 1527. 금민수의 개수
 */
public class BOJ_1527 {
	static int[] input = {4, 7};
	static int[] arr;
	static int res;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		arr = new int[B];
		
		countNum(0, new boolean[B]);
		
		System.out.println(res);
		
	}
	
	private static void countNum(int idx, boolean[] v) {
		if(idx == arr.length) {
			String tmp="";
			int is4or7=0;
			for(int i=0; i<arr.length; i++) {
				if(v[i]) {
					tmp += Integer.toString(arr[i]);
				}
			}
			for(int i=0; i<tmp.length(); i++) {
				if(tmp.charAt(i) == 4 || tmp.charAt(i) == 7) {
					is4or7++;
				}
			}
			if(is4or7 == tmp.length()) res++;
			
			return;
		}
		
		v[idx] = true;
		countNum(idx+1, v);
		v[idx] = false;
		countNum(idx+1, v);
		
		
	}
}
