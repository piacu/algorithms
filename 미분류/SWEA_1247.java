

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1247 {
	static List<Integer[]> ps;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int p = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int workX = Integer.parseInt(st.nextToken());
			int workY = Integer.parseInt(st.nextToken());
			int homeX = Integer.parseInt(st.nextToken());
			int homeY = Integer.parseInt(st.nextToken());
			int min=Integer.MAX_VALUE;
			Integer[] pp = new Integer[2];
			
			ps = new LinkedList<>();
			
			for(int i=0; i<p; i++) {
				pp[0] = Integer.parseInt(st.nextToken());
				pp[1] = Integer.parseInt(st.nextToken());
				ps.add(pp);
			}
			
			for(int i=0; i<p; i++) {
				int d = Math.abs(ps[i][0] - homeX) + Math.abs(ps[i][1] - homeY);
				if(d < min) {
					min = d;
				}
				
			}
			
			
		}
	}
	
	static void 
}
