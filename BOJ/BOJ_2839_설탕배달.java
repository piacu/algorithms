import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		
		while(N > 0) {
			if(N % 5 == 0) {
				N -= 5;
			} else if(N < 3){
				System.out.println(-1);
				return;
			} else {
				N -= 3;
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}
