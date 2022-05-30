import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4013_특이한자석 {
	static int[] mgnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/input_SWEA4013특이한자석.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(bf.readLine());

			mgnt = new int[4]; // 비트마스킹으로 톱니바퀴 입력
			for (int i = 0; i < mgnt.length; i++) {
				String str = "";
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < 8; j++) {
					str += st.nextToken();
				}
				for (int k = 7; k >= 0; k--) {
					if (str.charAt(7 - k) - '0' == 1)
						mgnt[i] += Math.pow(2, k);

				}
			}

			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				int wheel = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());

				checkMagnet(wheel, dir);
				wheelRotate(wheel, dir);
			}

		}

	}

	private static void checkMagnet(int wheel, int dir) {
		int first = 0;
		int second = 0;
		int third = 0;
		
		if((mgnt[0] & 4) > 0 != (mgnt[1] & 64) > 0) first = 1;
		if((mgnt[1] & 4) > 0 != (mgnt[2] & 64) > 0) second = 1;
		if((mgnt[2] & 4) > 0 != (mgnt[3] & 64) > 0) third = 1;
		
		switch(wheel) {
		case 1:
			if((mgnt[0] & 4) > 0 != (mgnt[1] & 64) > 0) {
				wheelRotate(mgnt[0], dir);
			}
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		}
		
	}

	private static void wheelRotate(int loc, int dir) {
		int tmpNum=0;
		
		// 좌측 방향일 때
		if (dir == -1) {
			if (mgnt[loc] >= 128) { // 맨 왼쪽 비트가 1이라면 저장
				mgnt[loc] -= 128;
				tmpNum=1;
			}
			mgnt[loc] <<= 1;
			mgnt[loc] += tmpNum; // 오른쪽에 비트 추가
		} 
		// 우측 방향일 때
		else {
			if(mgnt[loc] % 2 == 1) tmpNum=1; // 맨 오른쪽 비트가 1이라면 저장
			mgnt[loc] >>= 1;
			
			if(tmpNum==1) mgnt[loc] += 128; // 왼쪽에 비트 추가
		}

	}
}
