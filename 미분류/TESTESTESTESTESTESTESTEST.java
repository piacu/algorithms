import java.util.Scanner;

public class TESTESTESTESTESTESTESTEST {

	public static void main(String[] args) {

		// bit();

		//knapsack();
		//knapsack2();
		
		
		int a = 32 << 5;
		
		int b = 76;
		int c = b & 4;
//		a = 63 | 20;
		System.out.println("a : "+a);
		System.out.println("b : "+b);
		System.out.println("c : "+c);
		String str = Integer.toBinaryString(b);
		
		
		
		System.out.println(str);

	}

	private static void knapsack2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("물건 개수 : ");
		int thingsCnt = sc.nextInt();
		System.out.print("백팩 크기 : ");
		int backSize = sc.nextInt();
		
		int[] w = new int[thingsCnt + 10];
		int[] v = new int[thingsCnt + 10];
		int[] dp = new int[thingsCnt + 10];
		
		for (int i = 1; i <= thingsCnt; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		
		for(int i=1; i<thingsCnt; i++) {
			for(int j=backSize; j>=1; j--) {
				if(j - w[i] >= 0)
					dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
				
			}
			
		}
		
		System.out.printf("[%d] 크기의 백팩에 최대한 담을 수 있는 물건의 가치 : %d",backSize,dp[backSize]);

		
		
	}

	private static void knapsack() {
		Scanner sc = new Scanner(System.in);
		System.out.print("물건 개수 : ");
		int thingsCnt = sc.nextInt();
		System.out.print("백팩 크기 : ");
		int backSize = sc.nextInt();

		int[] w = new int[thingsCnt + 10];
		int[] v = new int[thingsCnt + 10];
		int[][] dp = new int[thingsCnt + 10][1000];

		for (int i = 1; i <= thingsCnt; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}

		for (int i = 1; i <= thingsCnt; i++) {
			for (int j = 1; j <= backSize; j++) {
				if (j - w[i] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}

			}
		}
		
		System.out.printf("[%d] 크기의 백팩에 최대한 담을 수 있는 물건의 가치 : %d",backSize,dp[thingsCnt][backSize]);

	}

	private static void bit() {
		int bit = 0;

		/*
		 * 0000 0000 bit OR 연산 0000 0100 | 1 << 2 ----------- 0000 0100
		 * 
		 * 0000 1011 bit AND 연산 0000 0100 & bitmask ----------- 0000 0000 => > 0
		 * 
		 * (bit & (1<<2)) > 0 ==> 3자리에 값이 1인지 판단할 수 있음
		 * 
		 */

		bit |= 1 << 2;

		System.out.println(bit);
	}

}
