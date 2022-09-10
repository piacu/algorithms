import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974_모든순열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());

		permutation(0, input, new int[input], new boolean[input]);
	}

	private static void permutation(int idx, int k, int sel[], boolean[] v) {
		if(idx == k) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			
			return;
		}
		
		for (int i = 0; i < sel.length; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[idx] = i+1;
				permutation(idx+1, k, sel, v);
				v[i] = false;
			}
		}
		
	}

}
