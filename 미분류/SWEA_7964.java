

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7964 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_SWEA7964.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int cities = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			char[] C = new char[cities+2];
			int res=0;
			
			C[0] = '1';
			C[cities+1] = '1';
			
			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			for(int i=1; i<C.length-1; i++) {
				C[i] = st2.nextToken().charAt(0);
			}
			
			int cnt=0;
			for(int i=1; i<C.length; i++) {
				if(C[i] == '1') cnt = 0;
				else cnt++;
				
				if(cnt == dist) {
					C[i] = '1';
					res++;
					cnt=0;
				}
				
			}
			
			System.out.printf("#%d %d\n",tc,res);
		
		}
 
	}

}
