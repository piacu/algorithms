import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1062 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 모든 단어에는 접두사 anta, 접미사 tica 가 포함되어 입력. 기본적으로 사용되는 문자 : a n t i c 5개
		
		if(K < 6) { // 접두사와 접미사 글자의 개수보다 작으면
			System.out.println(0);
			return;
		}
		
		ArrayList<Character> arr;
		int[] apb = new int[26];
		int res = 0;
		
		for(int i=0; i<N; i++) {
			arr = new ArrayList<>(Arrays.asList('a','n','t','i','c'));
			String str = bf.readLine();
			
			for(int j=4; j<str.length()-4; j++) { // 문자열 str에 포함된 문자 하나하나를 뽑아서 arraylist의 요소와 비교
				boolean isExist = false;
				
				for(int k=0; k<arr.size(); k++) {
					if(str.charAt(j) == arr.get(k)) {
						isExist = true;
						break;
					}
				}
				if(!isExist) {
					arr.add(str.charAt(j));
					apb[str.charAt(j) - 'a']++;
				}
			}
		}
		
//		for(int i=0; i<arr.size(); i++) {
//			System.out.print(arr.get(i)+" ");
//		}
		
		for(int i=0; i<apb.length; i++) {
			System.out.print(apb[i]+" ");
		}
		
		
//		for(int i=0; i<apb.length; i++) {
//			if(apb[i] >= K-5) {
//				res++;
//			}
//		}
		
		System.out.println();
		System.out.println(res);
		
	}

}
