

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1220 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int c = Integer.parseInt(bf.readLine());
			int[][] map = new int[100][100];
			
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int res=0;
			
			for(int i=0; i<100; i++) {
				
				Queue<Integer> q = new LinkedList<>();
				
				for(int j=0; j<100; j++) {
					if(map[j][i] > 0) {
						q.add(map[j][i]);
					}
				}
				
				while(!q.isEmpty()) {
					if(q.poll() == 1) {
						while(!q.isEmpty()) {
							if(q.poll() == 2) {
								res++;
								break;
							}
						}
					}
				}
				
				
			}
			
			System.out.printf("#%d %d\n",tc,res);
			
		}

	}

}
