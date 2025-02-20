import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {
	static int[] stack;
	static int index;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		stack = new int[N];
		index = 0;
		
		for (int i = 0; i < stack.length; i++) {
			String str = br.readLine();
			int res = readOperator(str);
			
			if(res >= -1)
				System.out.println(res);
			
		}
		
	}

	private static int readOperator(String str) {
		int size = str.length();
		
		if(size >= 6) { // operator == push
			stack[index] = Integer.parseInt(str.split(" ")[1]);
			index++;
		} else if(size == 5) { // operator == empty
			return index == 0 ? 1 : 0;
		} else if(size == 4) { // operator == size
			return index;
		} else if(index == 0) { // 인덱스가 0일 때 pop 또는 top 연산 시 -1 출력
			return -1;
		} else if(size == 3 && str.equals("pop")) {
			int num = stack[index-1];
			index--;
			return num;
		} else if(size == 3 && str.equals("top")) {
			return stack[index-1];
		}
		
		return -2;
	}

}