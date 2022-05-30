import java.util.Scanner;

public class BOJ_15649_N과M1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		permutation(0, M, new int[M], new boolean[N]);
		
		sc.close();
	}

	private static void permutation(int idx, int k, int[] sel, boolean[] v) {
		if(idx == k) {
			for(int i=0; i<sel.length; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<v.length; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[idx] = i+1;
				permutation(idx+1, k, sel, v);
				v[i] = false;
			}
		}
		
	}

}