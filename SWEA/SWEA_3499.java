import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * SWEA 3499. 퍼펙트 셔플
 */
public class SWEA_3499 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_SWEA3499.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for(int tc=1; tc<=T; tc++) {
			int nums = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String[] words = new String[nums];
			int oe = nums%2==0 ? 0 : 1; // 짝수이면 0, 홀수이면 1
			
			for(int i=0; i<nums; i++) {
				words[i] = st.nextToken();
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<nums/2+oe; i++) { // 홀수면 nums/2+1번
				System.out.print(words[i]+" ");
				if(i<nums/2) // 홀수면 nums/2 보다 1번 작게 동작
					System.out.print(words[nums/2+i+oe]+" ");
			}
			
			System.out.println();
			
		}
	}

}