

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("./src/input_SWEA6958.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] sol = new int[N][M];
			int max = 0;
			int maxP = 0;
			int res=0;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st2 = new StringTokenizer(bf.readLine());
				for(int j=0; j<M; j++) {
					sol[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				int sum=0;
				for(int j=0; j<M; j++) {
					sum += sol[i][j];
				}
				if(sum > max) {
					max = sum;
					maxP = 1;
				}
				else if(sum == max){
					maxP++;
				}
			}
			
			System.out.println("#"+tc+" "+maxP+" "+max);
			
		}

	}

}
