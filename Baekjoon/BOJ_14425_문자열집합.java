import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14425_문자열집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		String[] set = new String[N];
		for (int i = 0; i < set.length; i++) {
			set[i] = br.readLine();
		}
		String[] inputs = new String[M];
		for (int i = 0; i < inputs.length; i++) {
			inputs[i] = br.readLine();
		}
		
		for (int i = 0; i < set.length; i++) {
			for (int j = 0; j < inputs.length; j++) {
				if(set[i].equals(inputs[j])) {
					answer++;
					continue;
				}
			}
		}
		System.out.println(answer);
	}
	
}
