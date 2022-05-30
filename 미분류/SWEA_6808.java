

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_6808 {
	public static int[] kcard, icard, tmpcard;
	static int kWin, iWin;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_SWEA6808.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		kcard = new int[9];
		icard = new int[9];
		tmpcard = new int[9];
		
		for(int tc=1; tc<=T; tc++) {
			kWin = 0; iWin=0;
			boolean[] allCard = new boolean[18];
			
			for(int i=0; i<9; i++) {
				int num = sc.nextInt();
				kcard[i] = num;
				allCard[num-1] = true;
			}
			
			int c=0;
			for(int i=1; i<=18; i++) {
				if(allCard[i-1] == false) {
					icard[c] = i;
					c++;
				}
			}
			
			permutation(0, new boolean[9]);
			
			System.out.println("#"+tc+" "+kWin+" "+iWin);
		}

		sc.close();
	}

	private static void permutation(int cnt, boolean[] v) {
		if(cnt == 9) {
			int kW=0, iW=0;
			for(int i=0; i<9; i++) {
				if(kcard[i] > tmpcard[i]) kW += kcard[i]+tmpcard[i];
				else if(kcard[i] < tmpcard[i]) iW += kcard[i]+tmpcard[i];
			}
			if(kW > iW) kWin++;
			else if(kW < iW) iWin++;
			
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(v[i]) continue;
			
			tmpcard[i] = icard[cnt];
			v[i] = true;
			permutation(cnt+1, v);
			v[i] = false;
			
		}
		
	}
	

}