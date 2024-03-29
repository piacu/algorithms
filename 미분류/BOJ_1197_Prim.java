

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1197_Prim {
	static int parents[];
	static Vertex vt[];
	
	static class Vertex implements Comparable<Vertex>{
		int from, to, weight;

		public Vertex(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Vertex [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
		
	}
	
	static void makeSet(int V) {
		parents = new int[V+1];
		for(int i=0; i<V+1; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int n) {
		if(n == parents[n]) return n;
		else return parents[n] = findSet(parents[n]);
	}
	
	static boolean union(int from, int to) {
		int a = findSet(from);
		int b = findSet(to);
		
		if(a == b) return false;
		
		parents[b] = a;		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int res = 0;
		
		makeSet(V);
		
		vt = new Vertex[E];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			vt[i] = new Vertex(from, to, weight);
		}
		
		int[] minEdge = new int[V];
		boolean[] v = new boolean[V];
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[0] = 0;
		
		for(int c=0; c<V; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			
			for(int i=0; i<V; i++) {
				if(!v[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			v[minVertex] = true;
			res += min;
			
			for(int i=0; i<V; i++) { // 최소값 갱신
				// if(!v[i] && !v[findSet(i)]) ---> 구현중
			}
			
			
			
			
			
			
			
			
		}
		
		
		
		
		//System.out.println(Arrays.toString(vt));
		
//		for(Vertex vtx : vt) {
//			if(union(vtx.from, vtx.to)) {
//				res += vtx.weight;
//			}
//		}
		
		for(int i=0; i<E; i++) {
			if(union(vt[i].from, vt[i].to)) {
				res += vt[i].weight;
			}
		}
		
		System.out.println(res);
	}

}
