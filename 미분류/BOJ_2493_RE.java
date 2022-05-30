

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/*
 * BOJ 2493. 탑
 * 
  test_case
  5
  6 9 5 7 4
 */
public class BOJ_2493_RE {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Stack<int []> top = new Stack<>();
		
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			while(!top.isEmpty()) {
				if(top.peek()[0] < n)
					top.pop();
				else {
					System.out.print(top.peek()[1] + " ");
					break;
				}
			}
			
			/*
			 * 문제풀이 인터넷 참고 : https://wiselog.tistory.com/106, https://moonsbeen.tistory.com/204
			 * 추후 다시 풀어볼 예정입니다
			 */
			
			if(top.empty())
				System.out.print("0 ");
			top.push(new int[] {n, i+1});
			
		}
		
	}
}
