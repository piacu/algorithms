import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * SWEA 1210. [S/W 문제해결 기본] 2일차 - Ladder1
 */
public class SWEA_1210 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.setIn(new FileInputStream("input_SWEA1210.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[][] DIR = new int[][] {{-1,0}, //상
								   {0,-1}, //좌
								   {0, 1}};//우
		
		for(int tc=1; tc<=10; tc++) {
			int test = Integer.parseInt(bf.readLine());
			int[][] map = new int[100][100];
			int x=0, y=0;
			int LorR = 1; // 좌:0, 중간:1, 우:2
			
			for(int i=0; i<map.length; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int j=0; j<map[0].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) { // 2의 위치 입력
						x=i;
						y=j;
					}
				}
			}
			
			while(x>0) {
				int yl = y + DIR[1][1]; // 좌
				int yr = y + DIR[2][1]; // 우
				
				if(yl >= 0 && LorR <= 1 && map[x+DIR[1][0]][y+DIR[1][1]] == 1) { // 좌측에 1이 있으면
						y = y+DIR[1][1]; // 좌측으로 1칸 이동
						LorR = 0; // 좌
				}
				else if(yr < map.length && LorR >= 1 && map[x+DIR[2][0]][y+DIR[2][1]] == 1) { //우측에 1이 있으면
						y = y+DIR[2][1]; // 우측으로 1칸 이동
						LorR = 2; // 우
				} else {
					x -= 1; // 1칸 위로 상승
					LorR = 1; // 중간
				}
			}
			
			System.out.println("#"+tc+" "+y);
			
		}
	}
}