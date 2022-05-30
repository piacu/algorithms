import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_9205_맥주마시면서걸어가기 {
	static int[] dest;
	static int[][] cvs;
	static String res;
	static int beer = 1000;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/input_BOJ9205맥주마시면서걸어가기.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			res = "sad";
			
			// 시작점(상근이)의 좌표
			int[] sang = new int[] {sc.nextInt(), sc.nextInt()};
			
			// 편의점 좌표
			cvs = new int[N][2];
			for(int i=0; i<cvs.length; i++) {
				cvs[i][0] = sc.nextInt();
				cvs[i][1] = sc.nextInt();
			}
			
			// 도착지 좌표
			dest = new int[] {sc.nextInt(), sc.nextInt()};
			
			if(Math.abs(sang[0] - dest[0]) + Math.abs(sang[1] - dest[1]) <= beer) {
				System.out.println("happy");
			} else {
				BFS(sang[0], sang[1], new boolean[cvs.length]);
				//DFS(sang[0], sang[1], new boolean[cvs.length]);
				System.out.println(res);
			}
			
		}

		sc.close();
	}
	
	
	private static void BFS(int r, int c, boolean[] v) {
		Queue<int []> q = new LinkedList<>();
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			if(Math.abs(p[0] - dest[0]) + Math.abs(p[1] - dest[1]) <= beer) {
				res = "happy";
				return;
			}
			
			for(int i=0; i<cvs.length; i++) {
				if(Math.abs(p[0] - cvs[i][0]) + Math.abs(p[1] - cvs[i][1]) <= beer && !v[i]) {
					v[i] = true;
					q.add(new int[] {cvs[i][0], cvs[i][1]});
				}
			}
		}
		
	}

	// 시간초과 발생
	private static void DFS(int r, int c, boolean[] v) {
		if(Math.abs(r - dest[0]) + Math.abs(c - dest[1]) <= beer) {
			res="happy";
			return;
		}
		
		for(int i=0; i<cvs.length; i++) {
			if(Math.abs(r - cvs[i][0]) + Math.abs(c - cvs[i][1]) <= beer && !v[i]) {
				v[i] = true;
				//System.out.println("cvs["+i+"][0] : "+cvs[i][0]+" cvs["+i+"][1] : "+cvs[i][1]);
				DFS(cvs[i][0], cvs[i][1], v);
				v[i] = false;
			}
		}
	}

}
