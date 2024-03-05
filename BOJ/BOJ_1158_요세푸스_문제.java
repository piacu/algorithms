import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스_문제 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		sb.append("<");
		
		while(!q.isEmpty()) {
			for(int i=0; i<K-1; i++) {
				q.add(q.poll());
				
			}
				sb.append(", "+q.poll());
		}
		sb.append(">");
				
		System.out.println(sb.toString().replaceFirst(", ", ""));
	}
}