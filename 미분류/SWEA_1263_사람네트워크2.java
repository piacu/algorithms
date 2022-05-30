

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1263_사람네트워크2 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/algo_0404/input_SWEA1263.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[][] adj = new int[N][N];
			int[] resArr = new int[N];
			int res = 999999;
			
			for (int i = 0; i < adj.length; i++) {
				for (int j = 0; j < adj[0].length; j++) {
					adj[i][j] = sc.nextInt();
					if(i!=j && adj[i][j] == 0) {
						adj[i][j] = 999999;
					}
				}
			}
			
			// 경찰과 도둑 -> 경유지 출발지 도착지 순
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					if(i==k) continue; // 경유지랑 출발지랑 같으면 다음으로
					for(int j=0; j<N; j++) {
						if(i==j || j==k) continue; //출발지랑 도착지가 같거나(자기 자신 노드) 경유지랑 도착지랑 같으면(경유X) 다음으로
						else if (adj[i][j] > adj[i][k] + adj[k][j]){
							adj[i][j] = adj[i][k] + adj[k][j];
						}
					}
				}
			}
			
			for(int i=0; i<adj.length; i++) {
				for(int j=0; j<adj[0].length; j++) {
					resArr[i] += adj[i][j];
				}
				res = Math.min(res, resArr[i]);
			}
			
			System.out.printf("#%d %d\n",tc,res);
		}
		sc.close();
	}
}
