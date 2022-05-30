

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("./src/input_BOJ11399.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] jul = new int[T];
		int res=0, num=0;
		
		for(int i=0; i<T; i++) {
			jul[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(jul);
		
		for(int i=0; i<T; i++){
			num += jul[i];
			res += num;
		}
		
		System.out.println(res);
		
	}

}