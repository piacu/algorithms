import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M1 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		
		for(int i=0; i<N; ++i) {
			nums[i] = i + 1;
		}
		
		perm(0, nums, new int[M], new boolean[N]);
	}

	private static void perm(int idx, int[] nums, int[] arr, boolean[] v) {
		if(idx == arr.length) {
			for(int i=0; i<arr.length; ++i) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i=0; i<nums.length; ++i) { 
			if(!v[i]) { 
				v[i] = true;
				arr[idx] = nums[i];
				perm(idx+1, nums, arr ,v);
				v[i] = false;
			}
		}
	}

}
