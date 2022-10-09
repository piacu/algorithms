import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
	static int N, S, res;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		subset(0, new boolean[N]);
		
		System.out.println(res);
	}

	private static void subset(int idx, boolean[] sel) {
		if(idx == N) {
			int sum = 0;
			boolean isNull = true;
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					sum += arr[i];
					isNull = false;
				}
			}
			if(sum == S && !isNull) {
				res++;
			}
			return;
		}
		
		sel[idx] = true;
		subset(idx+1, sel);
		sel[idx] = false;
		subset(idx+1, sel);
	}
}
