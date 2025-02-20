import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724_연결_요소의_개수 {
	static List<List<Integer>> graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		graph = new ArrayList();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for(int i=0; i<=N; ++i) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		int answer = 0;
		boolean[] v = new boolean[graph.size()];
		
		for(int i=1; i<=N; ++i) {
			if(bfs(i, v)) ++answer;
		}
		
		System.out.println(answer);
	}

	private static boolean bfs(int vtx, boolean[] v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(vtx);
		
		if(v[vtx]) return false;
		
		v[vtx] = true;
		int max = 0;
		
		while(!queue.isEmpty()) {
			int poll = queue.poll();
			List<Integer> l = graph.get(poll);
			
			for(int i=0; i<l.size(); ++i) {
				if(!v[l.get(i)]) {
					queue.offer(l.get(i));
					v[l.get(i)] = true;
				}
			}
		}
		
		return true;
	}
}
