import java.util.Scanner;

public class BOJ_15650_N과M2 {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		combination(0, 0, N, new int[M]);
		
		sc.close();
	}

	private static void combination(int idx, int k, int N, int[] sel) {
		if(sel.length == k) {
			for(int i=0; i<sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		

		for(int i=idx; i<N; i++) {
			sel[k] = i+1;
			combination(i+1, k+1, N, sel);
		}
		
	}
	
}
