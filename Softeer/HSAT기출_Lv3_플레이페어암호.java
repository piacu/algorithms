import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HSAT기출_Lv3_플레이페어암호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msgInput = br.readLine();
		String keyInput = br.readLine();
		
		char[][] keyArray = getKey(keyInput);
		String msg = getMsg(msgInput);
		String result = "";

		for(int i=0; i<msg.length(); i+=2) {
			String check = "", trans;
			check = trans = msg.substring(i, i+2);
			
			trans = checkRowType(keyArray, trans);
			
			if(check.equals(trans)) {
				trans = checkColType(keyArray, trans);
				
				if(check.equals(trans)) {
					trans = checkOtherType(keyArray, trans);
				}
			}
			
			result += trans;
		}

		System.out.println(result);
	}

	private static String checkOtherType(char[][] keyArray, String msg) {
		char c1 = msg.charAt(0);
		char c2 = msg.charAt(1);

		int[] t1 = {-1, -1};
		int[] t2 = {-1, -1};
		
		for(int i=0; i<5; ++i) {				
			for(int j=0; j<5; ++j) {
				if(keyArray[i][j] == c1) {
					t1[0] = i;
					t1[1] = j;
				}
				if(keyArray[i][j] == c2) {
					t2[0] = i;
					t2[1] = j;
				}
			}
		}
		
		if(t1[0] != -1 && t2[0] != -1 && t1[0] != t2[0] && t1[1] != t2[1]) {
			c1 = keyArray[t1[0]][t2[1]];
			c2 = keyArray[t2[0]][t1[1]];
		}
		
		return c1 + "" + c2;
	}

	private static String checkColType(char[][] keyArray, String msg) {
		char c1 = msg.charAt(0);
		char c2 = msg.charAt(1);
		
		for(int i=0; i<5; ++i) {
			int t1 = -1;
			int t2 = -1;
			
			for(int j=0; j<5; ++j) {
				if(c1 == keyArray[j][i]) t1 = j;
				if(c2 == keyArray[j][i]) t2 = j;
			}
			
			if(t1 >= 0 && t2 >= 0) {
				c1 = keyArray[(t1+1)%5][i];
				c2 = keyArray[(t2+1)%5][i];
			}
		}

		return c1 + "" + c2;
	}

	private static String checkRowType(char[][] keyArray, String msg) {
		char c1 = msg.charAt(0);
		char c2 = msg.charAt(1);
		
		for(int i=0; i<5; ++i) {
			int t1 = -1;
			int t2 = -1;
			
			for(int j=0; j<5; ++j) {
				if(c1 == keyArray[i][j]) t1 = j;
				if(c2 == keyArray[i][j]) t2 = j;
			}
			
			if(t1 >= 0 && t2 >= 0) {
				c1 = keyArray[i][(t1+1)%5];
				c2 = keyArray[i][(t2+1)%5];
			}
		}

		return c1 + "" + c2;
	}

	private static String getMsg(String msgInput) {
		String msg = "";
		Queue<Character> queue = new LinkedList<>();
		
		for(char ch : msgInput.toCharArray()) {
			queue.add(ch);
		}
		
		while(!queue.isEmpty()) {
			char c = queue.poll();
			
			if(queue.isEmpty()) {
				msg += c + "X";
				break;
			}
			
			if(c == queue.peek()) {
				if(c == 'X') msg += c + "Q";
				else msg += c + "X";
			} else {
				msg += (char) c + "" + queue.poll();
			}
		}
		
		return msg;
	}

	private static char[][] getKey(String keyInput) {
		char[] checkKey = new char[26];
		String key = "";
		char[][] keyArray = new char[5][5];
		
		for(int i=0; i<26; ++i) {
			checkKey[i] = (char) (65 + i);
		}
		checkKey[9] = '\0'; // j

		for(int i=0; i<keyInput.length(); ++i) {
			int c = keyInput.charAt(i) - 65;
			
			if(checkKey[c] != '\0') {
				key += checkKey[c];
				checkKey[c] = '\0';
			}
		}
		
		while(key.length() < 25) {
			for(int i=0; i<26; ++i) {
				if(checkKey[i] != '\0') {
					key += checkKey[i];
					checkKey[i] = '\0';
					break;
				}
			}
		}
		
		int idx = 0;
		for(int i=0; i<5; ++i) {
			for(int j=0; j<5; ++j) {
				keyArray[i][j] = key.charAt(idx++);
			}
		}
		
		return keyArray;
	}
}
