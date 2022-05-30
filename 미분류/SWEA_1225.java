

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225 {
	/*
	 * SWEA 1225. [S/W 문제해결 기본] 7일차 - 암호생성기
	 */
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input_SWEA1225.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int testcase = 1; testcase <= 10; testcase++) {
			int tc = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			Queue<Integer> queue = new LinkedList<>();
			int check = 0;
			boolean status = true;

			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}

			while (status) {
				for (int i = 1; i <= 5; i++) {
					int num = queue.peek() - i;
					queue.poll();

					if (num <= 0) {
						queue.offer(0);
						status = false;
						break;
					}
					queue.offer(num);
				}
			}

			System.out.print("#" + tc);
			for (int i = 0; i < 8; i++) {
				System.out.print(" " + queue.poll());
			}
			System.out.println();
		}
	}

}
