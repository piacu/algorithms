

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238 {
	static boolean[][] v;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_SWEA1238.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int dataLength = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		v = new boolean[dataLength/2][2];
		
		int[][] data = new int[dataLength/2][2];
		
		StringTokenizer st2 = new StringTokenizer(bf.readLine());
		for(int i=0; i<dataLength/2; i++) {
			int r = Integer.parseInt(st2.nextToken());
			int c = Integer.parseInt(st2.nextToken());
			data[r][c] = 1;
		}
		
		//print(map);
		
		
		// bfs 사용
		
		bfs(start);
		
		
	}
	
	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(start);
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			System.out.println();
			
			for(Node temp=)
			
		}
		
		
		
	}
	
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
	}


	public static void print(boolean[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j]) System.out.print("t ");
				else System.out.print("f ");
			}
			System.out.println();
		}
	}
	
}
