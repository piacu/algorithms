import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1026_보물 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nums = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		
		List<Integer> A = new ArrayList<>();
		for (int i = 0; i < nums; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		
		List<Integer> B = new ArrayList<>();
		for (int i = 0; i < nums; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(A);
		Collections.sort(B, Collections.reverseOrder());
		
		for (int i = 0; i < nums; i++) {
			answer += A.get(i) * B.get(i);
		}
		System.out.println(answer);
	}

}
