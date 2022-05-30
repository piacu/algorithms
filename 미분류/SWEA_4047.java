

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * SWEA 4047. 영준이의 카드 카운팅
 */
public class SWEA_4047 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String str = bf.readLine();
			char[] arr = str.toCharArray();
			boolean[][] isExist = new boolean[13][4];
			int[] card = {'S','D','H','C'};
			boolean isERROR = false;
			
			L:for(int i=0; i<arr.length; i+=3) {
				for(int j=0; j<4; j++) {
					if(arr[i] == card[j]) {
						int plus = (arr[i+1] - '0')*10 + (arr[i+2] - '0');
						
						if(isExist[plus-1][j]) {
							isERROR=true;
							break L;
						} else {
							isExist[plus-1][j] = true;
						}
						
					}
				}
				
			}
			
			System.out.print("#"+tc+" ");
			
			if(isERROR) {
				System.out.print("ERROR");
			}else {
				for(int i=0; i<isExist[0].length; i++) {
					int ans = 0;
					for(int j=0; j<isExist.length; j++) {
						if(!isExist[j][i]) ans++;
					}
					System.out.print(ans+" ");
				}
				
			}
			
			System.out.println();
		}
		
	}

}
