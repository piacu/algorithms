

import java.util.Arrays;

public class BOJ_5585_su_up {
	static int[] arr = {500,400,100};
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		//물건을 사고 잔돈을 돌려받을거다 
		//동전의 종류는 500, 100원짜리가 있다
		//최소 동전개수로 잔돈을 돌려받는 프로그램을 작성하세요
		
		//잔돈 
		int val = 800;
		
		//잔돈이 0원이 될 때까지 계속 액수가 큰 동전으로 바꾼다. 
		//!!그리디!!
		
		//동전의 개수 
		int cnt=0;
		
		while (val>0) {
			if (val >= 500) {
				val -= 500;
				cnt++;
			}
			else if (val>=100) {
				val-=100;
				cnt++;
			}
		}
		System.out.println("잔돈의 갯수 : "+cnt);
	
		
		
		//만약 잔돈의 종류가 500,400,100이면 {400,400}을 뽑는게 베스트이므로 위 방법이 아닌 완전탐색을 돌려야 한다.
		//!!완전탐색!!
		recursive(0,new int[8],800);
		System.out.println(ans);
	}

	private static void recursive(int idx, int[] sel, int val) {
		//base part 
		//잔돈이 딱 떨어진경우 
		if (val==0) {
			ans = Math.min(ans, idx);
			System.out.println(Arrays.toString(sel));
			return;
		}
		//잔돈을 더 줄수 없는경우
		if (val<0) {
			return;
		}
		//inductive part
		for (int i = 0; i < arr.length; i++) {
			sel[idx] = arr[i];
			recursive(idx+1, sel, val-arr[i]);
			//back tracking
			sel[idx] = 0;
		}
	}

}
