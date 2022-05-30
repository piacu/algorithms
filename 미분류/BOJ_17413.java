

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
 * BOJ 17413. 단어 뒤집기 2
 */
public class BOJ_17413 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Queue<Character> q = new LinkedList<>();
		String st = bf.readLine();
		String res = "";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < st.length(); i++) {
			q.add(st.charAt(i));
		}

		while(!q.isEmpty()) {
			if (q.peek() == '<') {
				while(!stack.isEmpty()) res += stack.pop();
				while (q.peek() != '>') {
					res += q.poll();
				}
				res += q.poll();

			} else if (q.peek() == ' ') {
				while(!stack.isEmpty()) res += stack.pop();
				res += q.poll();
				
			} else {
				stack.add(q.poll());

			}

		}
		while(!stack.isEmpty()) res += stack.pop();
		System.out.println(res);

	}
}
