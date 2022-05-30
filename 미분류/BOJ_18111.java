

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111 {
	static int[][] map;
	static int Time=Integer.MAX_VALUE, Height;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int max=0, min=256;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				max = Math.max(map[i][j], max);
				min = Math.min(map[i][j], min);
			}
		}
		
		for(int h=min; h<=max; h++) { // min 높이부터 max 높이까지 하나씩 대입해봄
			BlockMove(h, B);
		}
		
		//System.out.println("max: "+max+"  min: "+min);
		System.out.println(Time+" "+Height);

	}
	private static void BlockMove(int H, int bag) {
		int time=0;
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				
				if(map[i][j] - H >= 0) { // H 높이보다 높다면 잘라내고 가방에 넣음
					bag += map[i][j] - H;
					time += 2 * (map[i][j] - H);
				}
				else if(map[i][j] - H < 0) { // H 높이보다 낮다면 가방에서 빼서 채움
					bag -= H - map[i][j];
					time += H - map[i][j];
				}
			}
		}
		
		if(bag < 0) return;
		
		if(time <= Time) {
			Time = time;
			Height = H;
		}
		
		
	}
	
}
