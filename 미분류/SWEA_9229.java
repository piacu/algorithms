

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229 {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		System.setIn(new FileInputStream("./src/input_SWEA9229.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			res = 0;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			int[] snack = new int[N];
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st2.nextToken());
			}

			combiSnack(snack, new int[2], M, 0, 0);

			System.out.println("#" + tc + " " + res);

		}
	}

	static int res;

	static void combiSnack(int[] snack, int[] choice, int M, int idx, int k) {

		if (choice.length == k) {
			if (choice[0] + choice[1] <= M) {
				res = Math.max(res, choice[0] + choice[1]);
			}
			return;
		}
		
		if(choice[0]==0||choice[1]==0) {
			res=-1;
		}

		for (int i = idx; i < snack.length; i++) {
			choice[k] = snack[i];
			combiSnack(snack, choice, M, i+1, k+1);
		}

	}

}
