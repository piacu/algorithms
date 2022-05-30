import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {
	static class Belt {
		int condition; // 내구도
		boolean isRobot;

		public Belt(int condition, boolean isRobot) {
			super();
			this.condition = condition;
			this.isRobot = isRobot;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/input_BOJ20055컨베이어벨트위의로봇.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int step = 1;

		ArrayList<Belt> blist = new ArrayList<>();

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N * 2; i++) {
			int cond = Integer.parseInt(st.nextToken());
			blist.add(new Belt(cond, false));
		}

		while (true) {
			
			Belt b = blist.get(blist.size()-1);
			blist.remove(blist.size()-1);
			blist.add(0, b);
			
			for (int i = N - 1; i >= 0; i--) {
				if (blist.get(i).isRobot) {
					
					if (i == N - 1) {
						blist.get(i).isRobot = false;
						continue;
					}
					
					if (blist.get(i + 1).condition > 0 && !blist.get(i+1).isRobot) {
						blist.get(i).isRobot = false;
						blist.get(i + 1).condition--;
						blist.get(i + 1).isRobot = true;
					}
				}
			}
			
			for(int i=N; i<N*2; i++) {
				blist.get(i).isRobot = false;
			}
			
			if(blist.get(0).condition > 0) { // 로봇 놓기
				blist.get(0).condition--;
				blist.get(0).isRobot = true;
			}
			
			int status=0;
			for(int i=0; i<blist.size(); i++) {
				//System.out.print("["+blist.get(i).condition+" "+blist.get(i).isRobot+"]");
				if(blist.get(i).condition == 0) status++;
			}
			//System.out.println();

			if(status >= K) break;
			
			step++;
		}

		System.out.println(step);
	}

}
