import java.util.Scanner;
/*
 * BOJ 2999. 비밀 이메일
 */
public class BOJ_2999 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String email = sc.next();
		int R = 0;
		int C = 1;
		String result = "";
		
		int k=2;
		while(R < C) {
			if(email.length() % k == 0) { // 이메일 길이를 k로 나누었을 때 나머지가 없을 때
				R = k; 
				C = email.length() / k; 
			}
			k++;
		}
		
		char[][] array = new char[C][R]; // R이 C보다 커져서 while문을 탈출했기 때문에 거꾸로 삽입해 줌
		
		int cnt=0;
		for(int i=0; i<R; i++) { // 문자 하나씩 열-행 순으로 입력
			for(int j=0; j<C; j++) {
				array[j][i] = email.charAt(cnt);
				++cnt;
			}
		}
		
		for(int i=0; i<C; i++) { // 문자 하나씩 행-열 순으로 result에 입력
			for(int j=0; j<R; j++) {
				result += array[i][j];
			}
		}

		System.out.println(result);
		
		sc.close();
	}

}
