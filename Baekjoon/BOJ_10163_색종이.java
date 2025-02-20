import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] map = new int[1001][1001];
		
		for(int tc=1; tc<=T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int r_add = Integer.parseInt(st.nextToken());
			int c_add = Integer.parseInt(st.nextToken());
			
			for(int i=r; i<r+r_add; ++i) {
				for(int j=c; j<c+c_add; ++j) {
					map[i][j] = tc;
				}
			}
		}
		
		int[] res = new int[T+1];
		
		for(int i=0; i<1001; ++i) {
			for(int j=0; j<1001; ++j) {
				++res[map[i][j]];
			}
		}
		
		for(int i=1; i<=T; ++i) {
			System.out.println(res[i]);
		}
	}
}
