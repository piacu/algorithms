

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input_BOJ1158.txt"));
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
		
//		int cnt=1;
		
		while(!q.isEmpty()) {
			for(int i=0; i<K-1; i++)
				q.add(q.poll());
				
				sb.append(", "+q.poll());
			
//			q.add(q.poll());				// 시간초과 발생 코드
//			cnt++;
//			if(cnt==K) {
//				sb.append(", "+q.poll());
//				cnt=1;
//			}
		}
		sb.append(">");
				
		System.out.println(sb.toString().replaceFirst(", ", ""));
		
	}
}
