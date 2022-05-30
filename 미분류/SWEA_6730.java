

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6730 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input_SWEA6730.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int tcNum = Integer.parseInt(bf.readLine());
			int[] arr = new int[tcNum];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int up = 0, down = 0;

			for (int i = 0; i < tcNum; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < tcNum-1; i++) {
					if (arr[i] - arr[i+1] < 0) {
						if(arr[i] - arr[i+1] < up)
							up = arr[i]-arr[i+1];
					}
					if (arr[i] - arr[i+1] > 0) {
						if(arr[i] - arr[i+1] > down)
							down = arr[i]-arr[i+1];
					}
			}

			System.out.println("#" + tc + " " + Math.abs(up) + " " + down);

		}

	}
}
