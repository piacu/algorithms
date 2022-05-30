

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2383_점심식사시간 {

	static class Person implements Comparable<Person> {
		int r, c, time, status, downCnt;

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public void init() {
			time = downCnt = 0;
			status = M;
		}

		@Override
		public int compareTo(Person o) {
			return this.time - o.time;
		}
		@Override
		public String toString() {
			return "Person [r=" + r + ", c=" + c + ", time=" + time + ", status=" + status + "]";
		}
	}

	static final int M = 1, W = 2, D = 3, E = 4; // move wait down exit
	static List<Person> ps;
	static int pSize;
	static int[][] stairs;
	static int Ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			Ans = Integer.MAX_VALUE;
			int N = Integer.parseInt(bf.readLine());

			ps = new ArrayList<>();
			stairs = new int[2][];
			for (int i = 0, k = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					int len = Integer.parseInt(st.nextToken());
					if (len == 1) {
						ps.add(new Person(i, j));
					}
					if (len > 1) {
						stairs[k++] = new int[] {i, j, len};
					}
				}
			}
			
			pSize = ps.size();
			peopleSet(0, new boolean[pSize]);
			System.out.printf("#%d %d\n", tc, Ans);
		}

	}

	private static void peopleSet(int idx, boolean[] selected) {
		if(idx == pSize) {
			moveToStair(selected);
			return;
		}
		
		selected[idx] = true;
		peopleSet(idx+1, selected);
		selected[idx] = false;
		peopleSet(idx+1, selected);
	}

	private static void moveToStair(boolean[] selected) {
		ArrayList<Person> alist = new ArrayList<>();
		ArrayList<Person> blist = new ArrayList<>();
		
		for(int i=0; i<selected.length; i++) {
			Person p = ps.get(i);
			p.init();
			if(selected[i]) {
				p.time = Math.abs(p.r - stairs[0][0]) + Math.abs(p.c - stairs[0][1]);
				alist.add(p);
			} else {
				p.time = Math.abs(p.r - stairs[1][0]) + Math.abs(p.c - stairs[1][1]);
				blist.add(p);
			}
		}
		
		int timeA = downStair(alist, stairs[0][2]);
		int timeB = downStair(blist, stairs[1][2]);
		
		int min = Math.max(timeA, timeB);
		Ans = Math.min(Ans, min);
		
	}

	private static int downStair(ArrayList<Person> list, int height) {
		int size = list.size();
		if(size == 0) return 0;
		
		Collections.sort(list);
		
		int time=list.get(0).time;
		int ingCnt = 0, cCnt = 0;
		while(true) {
			for(int i=0; i<list.size(); i++) {
				Person p = list.get(i);

				if(p.status == E) continue;
				
				if(p.time == time) {
					p.status = W;
				} else if(p.status == W && ingCnt < 3) {
					p.status = D;
					p.downCnt = 1;
					++ingCnt;
				} else if(p.status == D) {
					if(p.downCnt < height) {
						p.downCnt++;
					} else {
						p.status = E;
						++cCnt;
						--ingCnt;
					}
				}
			}
			if(cCnt == size) break;
			++time;
		}
		
		return time;
	}
}
