import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_16637_괄호추가하기 {
	static int operands;
	static Queue<Character> stmt;
	static List<Integer> nums;
	static List<Character> ops;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());
		String array = bf.readLine();

		nums = new LinkedList<Integer>();
		ops = new LinkedList<Character>();
		stmt = new LinkedList<Character>();
		
		for(int i=0; i<T; i++) {
			char ch = array.charAt(i);
			
			// 연산자가 입력되었을 때
			if(ch == '+' || ch == '-' || ch == '*') {
				ops.add(ch);
				continue;
			}
			
			// 숫자가 입력되었을 때
			nums.add(ch-'0');
		}
		
		powerSet(0, nums.size(), new boolean[nums.size()]);
		
	}
	
	private static char calc(char o1, char operator, char o2) {
		int op1 = o1 - '0';
		int op2 = o2 - '0';
		int output = 0;
		
		if(operator == '+') output = op1+op2;
		else if(operator == '-') output = op1-op2;
		else if(operator == '*') output = op1*op2;
		
		return (char)(output + '0');
	}
	
	private static void powerSet(int idx, int k, boolean[] v) {
		if(idx == k) {
			
//			for(int i=0; i<v.length; i++) {
//				if(v[i])
//					System.out.print(i+" ");
//			}
//			System.out.println();
			return;
		}
		
		v[idx] = true;
		powerSet(idx+1, k, v);
		v[idx] = false;
		powerSet(idx+1, k, v);
	}

}
