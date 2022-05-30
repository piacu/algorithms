import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int r;
	int c;
	
	public Pos(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class BOJ_2234 {
	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static int dr[] = {1,0,-1,0}; // 남 동 북 서
	static int dc[] = {0,1,0,-1}; // 8 4 2 1 -> 최대값 15
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		v = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!v[i][j])
					bfs(i,j);
			}
		}
		
		print();
		
	}
	private static void bfs(int i, int j) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(i, j));
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			v[p.r][p.c] = true;
			
			for(int d=0; d<4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && check(p, d) && !v[nr][nc]) {
					q.add(new Pos(nr,nc));
				}
			}
			
			
			
		}
	}
	
	private static boolean check(Pos p, int d) {
		String val = Integer.toBinaryString(map[p.r][p.c]);

		System.out.println(val);
		if(val.length() < d) return true;
		else if(val.charAt(d) == 1) return false;
		else return true;
		
	}

	private static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
