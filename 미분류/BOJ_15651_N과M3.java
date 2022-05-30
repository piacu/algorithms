import java.util.Scanner;

public class BOJ_15651_N과M3 {
	static StringBuilder sb;
	public static void main(String[] args) {
		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		combination(0, 0, N, new int[M]);
		
		System.out.println(sb);
		sc.close();
	}

	private static void combination(int idx, int k, int N, int[] sel) {
		if(sel.length == k) {
			for(int i=0; i<sel.length; i++) {
				sb.append(sel[i]+" ");
			}
			sb.append("\n");
			return;
		}
		

		for(int i=0; i<N; i++) {
			sel[k] = i+1;
			combination(i, k+1, N, sel);
		}
		
	}
	
}
