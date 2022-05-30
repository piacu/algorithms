import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 2869. 달팽이는 올라가고 싶다
 */
public class BOJ_2869 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int cnt = 1;

		V -= A;

		if (V <= 0) {
			System.out.println(cnt);
			return;
		}
		
		if (V < A) {
			cnt++;
		}else if(V%(A-B)>0)
			cnt++;
		
		cnt += V / (A - B);

		System.out.println(cnt);
	    
	}

}
