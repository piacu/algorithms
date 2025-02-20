import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 2563. 색종이
 */
public class BOJ_2563_색종이 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_BOJ2563.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine()); // 색종이 개수
		int[][] paper = new int[T][2]; // 색종이 테스트케이스
		boolean[][] map = new boolean[100][100]; // 100 x 100 도화지 생성(기본값은 false)
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			paper[i][0] = Integer.parseInt(st.nextToken()); // x값 저장
			paper[i][1] = Integer.parseInt(st.nextToken()); // y값 저장
		}
		
		for(int i=0; i<T; i++) {
			int pH = paper[i][0]; // i번째 색종이의 x값 입력
			int pW = paper[i][1]; // i번째 색종이의 y값 입력
			
			for(int j=pH-1; j<pH+9; j++) { // 배열은 0부터 시작하기 때문에 1을 뺄셈 해주고 반복 횟수는 9를 더했다
				for(int k=pW-1; k<pW+9; k++) {
					map[j][k] = true; // 색종이 입력
				}
			}
		}
		int cnt=0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j]) cnt++; // true 값일 때 cnt 증가
			}
		}
		
		System.out.println(cnt);

	}

}
