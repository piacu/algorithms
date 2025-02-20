import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	static StringBuilder sb = new StringBuilder();
	static int L;
	static int C;
	static char[] pwChar;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		pwChar = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < pwChar.length; i++) {
			pwChar[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(pwChar);
		
		backtrack(0, 0, new char[L]);
		
		System.out.println(sb.toString());
	}
	
	private static void backtrack(int idx, int x, char[] result) {
		if(idx == L) {
			if(!checkArr(result)) return;
			
			for(int i=0; i<result.length; i++) {
				sb.append(result[i]);
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=x; i<C; i++) {
			result[idx] = pwChar[i];
			backtrack(idx+1, i+1, result);
		}
			
	}
	
	private static boolean checkArr(char[] result) {
		int moeum = 0;
		int jaeum = 0;
		
		for (int i = 0; i < result.length; i++) {
			if(result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
				moeum++;
			} else {
				jaeum++;
			}
		}
		
		if(moeum >= 1 && jaeum >=2) return true;
		else return false;
	}

}
