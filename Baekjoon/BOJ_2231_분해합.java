import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231_분해합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= num; i++) {
			int sum = i + addNum(i);
			if(sum == num) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}

	private static int addNum(int num) {
		return num%10 + num/10%10 + num/100%10 + num/1000%10 + num/10000%10 + num/100000%10 + num/1000000%10;
	}

}
