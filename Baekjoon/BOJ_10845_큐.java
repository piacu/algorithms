import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10845_큐 {
	static int[] queue;
	static int index;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		queue = new int[N];
		index = 0;
		
		for (int i = 0; i < queue.length; i++) {
			String str = br.readLine();
			int res = readOperator(str);
			
			if(res >= -1)
				System.out.println(res);
			
		}
		
	}

	private static int readOperator(String operator) {		
		if(operator.length() >= 6) { // operator == push
			queue[index] = Integer.parseInt(operator.split(" ")[1]);
			index++;
		} else if(operator.equals("empty")) { // operator == empty
			return index == 0 ? 1 : 0;
		} else if(operator.equals("size")) { // operator == size
			return index;
		} else if(index == 0) { // 인덱스가 0일 때 pop 또는 top 연산 시 -1 출력
			return -1;
		} else if(operator.equals("pop")) {
			int num = queue[0] > 0 ? queue[0] : -1;
			
			for (int i = 0; i < index; i++) {
				queue[i] = queue[i+1];
			}
			index--;
			return num;
		} else if(operator.equals("front")) {
			return queue[0];
		} else if(operator.equals("back")) {
			return queue[index-1];
		}
		
		return -2;
	}

}