import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1527_금민수의_개수 {
	static int RES = 0;
	static int A, B;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		recursive(4);
		recursive(7);
		
		System.out.println(RES);
	}
	
	private static void recursive(long num) {
		if(num > B) return;
		if(num >= A && num <= B) RES++;
		
		recursive(num * 10 + 4);
		recursive(num * 10 + 7);
		
		
	}

}
