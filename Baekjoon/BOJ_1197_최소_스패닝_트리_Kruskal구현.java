import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1197_최소_스패닝_트리_Kruskal구현 {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] graph = new int[E][3];
		
		for(int i=0; i<E; ++i) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);
		parent = new int[V+1];
		
		for(int i=0; i<V+1; ++i) {
			parent[i] = i;
		}
		
		System.out.print(kruskal(graph));
	}

	private static long kruskal(int[][] graph) {
		long ans = 0;
		
		for(int i=0; i<graph.length; ++i) {
			if(find(graph[i][0]) != find(graph[i][1])) {
				ans += graph[i][2];
				union(graph[i][0], graph[i][1]);
			}
		}
		
		return ans;
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}

	private static int find(int n) {
		if(parent[n] == n) return n;
		else return parent[n] = find(parent[n]);
	}

}
