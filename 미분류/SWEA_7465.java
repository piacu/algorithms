

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7465 {
	static int p[];
	static boolean v[];
	
	static int findSet(int num) {
		if(p[num] == num) return num;
		else return p[num] = findSet(p[num]);
	}
	
	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if(aRoot == bRoot) return;
			
		p[bRoot] = aRoot;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken())+1;
			int M = Integer.parseInt(st.nextToken());
			p = new int[N];
			v = new boolean[N];
			
			int cnt=0;
			
			for(int i=1; i<N; i++) {
				p[i] = i;
			}
			
			for(int i=1; i<=M; i++) {
				st = new StringTokenizer(bf.readLine());
				int idx = Integer.parseInt(st.nextToken());
				int parent = Integer.parseInt(st.nextToken());
				union(idx,parent);
			}
			
			for (int i = 1; i < N; i++) {
				System.out.print(p[i]+" ");
			}
			
			
			
			for(int i=1; i<N; i++) {
				int f = findSet(i);
				if(!v[f]) {
					cnt++;
					v[f] = true;
				}
			}
			
			
			
			System.out.printf("#%d %d\n",tc,cnt);
			
			
		}
		
	}
}
