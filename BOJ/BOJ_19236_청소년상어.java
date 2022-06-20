import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class State implements Comparable<State>{
	int r; // 행
	int c; // 열
	int num; // 번호
	int dir; // 방향
	
	public State(int r, int c, int num, int dir) {
		super();
		this.r = r;
		this.c = c;
		this.num = num;
		this.dir = dir;
	}

	@Override
	public int compareTo(State o) {
		return this.num - o.num;
	}

	@Override
	public String toString() {
		return "State [r=" + r + ", c=" + c + ", num=" + num + ", dir=" + dir + "]";
	}
	
}
public class BOJ_19236_청소년상어 {
	static List<State> list;
	static int[][] drc = {{0,0},{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}}; // null, ↑, ↖, ←, ↙, ↓, ↘, →, ↗
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				list.add(new State(i, j, num, dir));
			}
		}
		
		list.get(0).num = 0; // 상어로 초기화
		Collections.sort(list); // 리스트 정렬
		
		for (State state : list) {
			System.out.println(state.toString());
		}
		
		
	}

	private static void dfs(State s) {
		
		moveFish();
	}

	private static void moveFish() {
		int currentFish = 0;
		
		while(currentFish <= 16) {
//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map.length; j++) {
//					if(map[i][j].num == currentFish) {
//						int mr = i + drc[map[i][j].dir][0];
//						int mc = j + drc[map[i][j].dir][1];
//						
//						if(mr > 0 && mr < map.length && mc > 0 && mc < map.length && map[mr][mc].num != 0) {
//							State tmp = map[i][j];
//							map[i][j] = map[mr][mc];
//							map[mr][mc] = tmp;
//						}
//						
//					}
//				}
//			}
			currentFish++;
		}
		
	}
}
