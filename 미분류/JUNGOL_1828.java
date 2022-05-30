

import java.util.Scanner;

public class JUNGOL_1828 {
	static int N, res = 1;
	static int[][] matter;
	static int[][] temp;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		matter = new int[N][2];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				matter[i][j] = sc.nextInt();
			}
		}
		
		temp = new int[N][2];
		temp[0][0] = matter[0][0];
		temp[0][1] = matter[0][1];
		
		
		refridge(0, 0, new boolean[N]);
		
		System.out.println(res);
		
		
		
		sc.close();
	}

	private static void refridge(int cnt, int idx, boolean[] v) {
		if(cnt == N) {
			res = temp.length;
			return;
		}
		
		for(int i=1; i<N; i++) {
			if(matter[i][0] > temp[j][1] || matter[i][1] < temp[j][0]) { // 다음 물질의 최저온도가 기존 최대보다 높거나, 최대온도가 기존보다 낮을 때 
				temp[idx][0] = matter[i][0];
				temp[idx][1] = matter[i][1];
				refridge(cnt, idx+1, v);
			
			}
			
			refridge(cnt+1, idx+1, v);
			
		}
		
	}
	
}
