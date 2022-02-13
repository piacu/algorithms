import java.util.Scanner;
import java.io.FileInputStream;
/*
 * SWEA 2805. 농작물 수확하기
 */
class SWEA_2805 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input_2805.txt"));
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int[][] garden = new int[N][N];
            int sum=0;
            
            for(int i=0; i<N; i++){
            	String str = sc.next();
                for(int j=0; j<N; j++){
                	garden[i][j] = str.charAt(j) - '0'; // 문자에서 숫자로 변환 후 int 배열에 입력
                }
            }
            
            int cnt1 = N/2, cnt2 = N/2;
            
            for(int i=0; i<=N/2; i++){ // 마름모를 삼각형 두 개로 나누어서 덧셈(△ 삼각형)
                for(int j=cnt1; j<=cnt2; j++){
                    sum += garden[i][j];
                }
            	cnt1--;
           	 	cnt2++;
            }
            
            cnt1 = N/2;
            cnt2 = N/2;
            
            for(int i=N-1; i>N/2; i--){ // 마름모를 삼각형 두 개로 나누어서 덧셈(▽ 삼각형)
                for(int j=cnt1; j<=cnt2; j++){
                    sum += garden[i][j];
                }
            	cnt1--;
           	 	cnt2++;
            }
                
            System.out.println("#"+test_case+" "+sum);
 
		}
		sc.close();
	}
}