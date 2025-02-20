import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			map[from][to] = map[to][from] = 1;
		}
		
		sb = new StringBuilder();
		
		dfs(map, V, new boolean[N+1]);
		sb.append("\n");
		bfs(map, V);
		
		
//		print(map);

		System.out.println(sb);
	}

	private static void dfs(int[][] map, int node, boolean[] visit) {
		sb.append(node+" ");
		visit[node] = true;
		
		for (int i = 1; i < map.length; i++) {
			if(map[node][i] == 1 && !visit[i]) {
				dfs(map, i, visit);
			}
		}
		
	}

	private static void bfs(int[][] map, int node) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visit = new boolean[map.length+1];
		visit[node] = true;
		q.add(node);
		
		while(!q.isEmpty()) {
			int V = q.poll();
			sb.append(V+" ");
			
			for (int i = 1; i < map.length; i++) {
				if(map[V][i] == 1 && !visit[i]) {
					visit[i] = true;
					q.add(i);
				}
			}
		}
		
	}

	private static void print(int[][] map) {
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
