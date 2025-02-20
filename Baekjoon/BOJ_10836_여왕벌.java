import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10836_여왕벌 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int m = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		int[] space = new int[m*2-1];
		
		Arrays.fill(space, 1);
		
		for(int d=0; d<day; d++) {
			st = new StringTokenizer(br.readLine());
			int zero = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());

			for(int i=0; i<space.length; i++) {
				if(zero-- > 0) {
					continue;
				}
				else if(one-- > 0) {
					space[i]++;
				}
				else if(two-- > 0) {
					space[i] += 2;
				}
			}
			
		}
		
		for(int i=m-1; i>=0; i--) {
			sb.append(space[i]+" ");
			for(int j=m; j<space.length; j++) {
				sb.append(space[j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}