import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {
	static char[] words;
	static int L, C;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		words = new char[C];
		sb = new StringBuilder();
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<C; i++) {
			words[i] = st.nextToken().charAt(0);
		}
		
		// a t c i s w -> a c i s t w
		Arrays.sort(words);
		
		combination(0, 0, new char[L]);
		System.out.println(sb.toString());
	}
	
	private static void combination(int idx, int k, char[] sel) {
		if(sel.length == k) {
			boolean moeum = false;
			int jaeum = 0;
			for(int i=0; i<sel.length; i++) {
				if(sel[i] == 'a' || 
				   sel[i] == 'e' || 
				   sel[i] == 'i' || 
				   sel[i] == 'o' || 
				   sel[i] == 'u') moeum = true;
				else if(sel[i] > 'a' && sel[i] < 'z') jaeum++;
			}
			if(!moeum || jaeum < 2) return;
			
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]);
			}
			sb.append("\n");
			return;
		}
		
		for (int i = idx; i < words.length; i++) {
			sel[k] = words[i];
			combination(i+1, k+1, sel);
		}
		
	}

}
