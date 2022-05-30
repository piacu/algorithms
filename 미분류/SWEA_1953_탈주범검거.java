

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {
	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int N, M, Ans;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken()); // 맵 세로크기
			M = Integer.parseInt(st.nextToken()); // 맵 가로크기
			int R = Integer.parseInt(st.nextToken()); // 맨홀 세로위치 
			int C = Integer.parseInt(st.nextToken()); // 맨홀 가로위치
			int L = Integer.parseInt(st.nextToken()); // 소요시간
			
			map = new int[N][M];
			v = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			manhole_bfs(R, C, L);
			
			System.out.printf("#%d %d\n", tc, Ans);
			Ans=0;
		}
	}
	

	private static void manhole_bfs(int r, int c, int L) {
		Queue<Point> q = new LinkedList<>();
		v[r][c] = true;
		Ans++;
		q.add(new Point(r,c,1));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int[][] dir = checkDir(p.r, p.c);
			
			for(int i=0; i<dir.length; i++) {
				int nr = p.r + dir[i][0];
				int nc = p.c + dir[i][1];
				
				
				
				if(p.cnt == L) {
					return;
				}
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc] != 0 && !v[nr][nc]) {
					if(checkcheck(dir[i][0], dir[i][1], map[nr][nc])) {
						v[nr][nc] = true;
						Ans++;
						q.add(new Point(nr,nc,p.cnt+1));
					}
				}
			}	
		}
	}
	
	private static boolean checkcheck(int cr, int cc, int next) {
		
		if(cr==-1 && cc==0) { // 위 방향이면
			if(next==1 || next==2 || next==5 || next==6) return true;
			
		} else if(cr==1 && cc==0) { // 아래 방향이면
			if(next==1 || next==2 || next==4 || next==7) return true;
			
		} else if(cr==0 && cc==-1) { // 왼쪽 방향이면
			if(next==1 || next==3 || next==4 || next==5) return true;
			
		} else if(cr==0 && cc==1) { // 오른쪽 방향이면
			if(next==1 || next==3 || next==6 || next==7) return true;
		}
		
		return false;
	}


	private static int[][] checkDir(int r, int c) {
		int chkNum = map[r][c];
		int[] up = {-1,0};
		int[] dn = {1, 0};
		int[] le = {0,-1};
		int[] ri = {0, 1};
		
		if(chkNum == 1)			return new int[][] {up, dn, le, ri}; // 상하좌우
		else if(chkNum == 2)	return new int[][] {up, dn}; // 상하
		else if(chkNum == 3)	return new int[][] {le, ri}; // 좌우
		else if(chkNum == 4)	return new int[][] {up, ri}; // 상우
		else if(chkNum == 5)	return new int[][] {dn, ri}; // 하우
		else if(chkNum == 6)	return new int[][] {dn, le}; // 하좌
		else if(chkNum == 7)	return new int[][] {up, le}; // 상좌
		
		return null;
	}
	
	private static void print(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}

}
