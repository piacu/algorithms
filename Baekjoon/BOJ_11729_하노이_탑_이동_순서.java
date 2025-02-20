import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729_하노이_탑_이동_순서 {
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		sb.append((int) (Math.pow(2, N) - 1)).append("\n");
		hanoi(N, 1, 2, 3);
		
		System.out.println(sb);
	}

	private static void hanoi(int N, int from, int mid, int to) {
		if(N == 1) {
			sb.append(from + " " + to).append("\n");
			return;
		}
		
		hanoi(N-1, from, to, mid);
		sb.append(from + " "+ to).append("\n");
		hanoi(N-1, mid, from, to);
	}
}