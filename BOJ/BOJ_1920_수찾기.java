import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] B = new int[M];
		
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		for (int i = 0; i < B.length; i++) {
			if(binarySearch(A, B[i], 0, N-1) == 1) System.out.println(1);
			else System.out.println(0);
		}
		
	}

	private static int binarySearch(int[] arr, int target, int low, int high) {
		if(low > high) return -1;
		
		int mid = (low + high) / 2;
		if(arr[mid] == target) {
			return 1;
		} else if(arr[mid] > target) {
			return binarySearch(arr, target, low, mid-1);
		} else {
			return binarySearch(arr, target, mid+1, high);
		}
		
	}

}