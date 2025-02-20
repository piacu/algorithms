import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_11279_최대_힙 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(q.isEmpty()) sb.append(0);
				else sb.append(q.poll());
				
				sb.append("\n");
			} else {
				q.add(num);
			}
		}
		System.out.println(sb);
	}
}
