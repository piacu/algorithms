import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6987_월드컵 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] gyunggi = new int[1][18];
		for(int i=0; i<gyunggi.length; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < gyunggi[0].length; j++) {
				gyunggi[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < gyunggi.length; i++) {
			boolean res = true;
			int totalWin=0, totalSame=0, totalLose = 0;
			int sameAlgo[] = new int[6];
			
			for (int j = 0; j < gyunggi[0].length; j+=3) {
				int win = gyunggi[i][j];
				int same = gyunggi[i][j+1];
				int lose = gyunggi[i][j+2];
				
				if(win+same+lose != 5) res = false; // 한 조가 5경기를 치르지 않는 건 불가능
				
				totalWin += win;
				totalSame += same;
				totalLose += lose;
				
			}
			
			if(totalWin != totalLose) res = false; // 승리와 패배 결과가 같아야 함
			
			
			
			System.out.print((res == true ? 1 : 0)+" ");
		}
		
		

	}

}

/*

5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3
5 0 0 4 0 1 2 2 1 2 0 3 1 0 4 0 0 5
5 0 0 3 1 1 2 1 1 2 0 3 0 0 5 1 0 4


*/