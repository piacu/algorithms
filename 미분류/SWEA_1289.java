import java.io.FileInputStream;
import java.util.Scanner;
/*
 * SWEA 1289. 원재의 메모리 복구하기
 */
public class SWEA_1289 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/input_BOJ17478.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			char num = '0';
			int count=0;
			
			
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) != num) { // 현재 메모리 위치의 내용이 이전의 위치의 내용과 다르다면
					num = str.charAt(i); // 현재 번호 역전(0->1 or 1->0)
					count++; // 고친 횟수 증가
				}
			}
			
			System.out.println("#"+test_case+" "+count);
			
		}
		sc.close();
	}
}
