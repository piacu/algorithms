

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_16935 {
	static Stack<Integer> stack = new Stack<>();
	static Queue<Integer> queue = new LinkedList<>();
	static int[][] map;
	static int[][] rmap;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input_BOJ16935.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Math.max(N, M);
		map = new int[Q][Q];
		rmap = new int[Q][Q];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			for(int j=0; j<M; j++) {
				 map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		StringTokenizer st3 = new StringTokenizer(bf.readLine());
		
		while(st3.hasMoreTokens()) {
			int num = Integer.parseInt(st3.nextToken());
			
			switch(num) {
			case 1:
				reverseUpDown(N, M);
				break;
			case 2:
				reverseLeftRight(N, M);
				break;
			case 3:
				rotationRight90(N, M);
				break;
			case 4:
				//rotationLeft90();
				break;
			case 5: case 6:
				//subArray();
				break;
			default:
				break;
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				 System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	private static void rotationRight90(int N, int M) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				queue.offer(map[i][j]);
			}
			for(int k=0; k<N; k++) {
				map[k][M-i-1] = queue.poll();
			}
		}
	}
	private static void reverseUpDown(int N, int M) {
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				stack.push(map[j][i]);
			}
			for(int k=0; k<N; k++) {
				map[k][i] = stack.pop();
			}
		}
	}
	private static void reverseLeftRight(int N, int M) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				stack.push(map[i][j]);
			}
			for(int k=0; k<M; k++) {
				map[i][k] = stack.pop();
			}
		}
	}
	
	

}
