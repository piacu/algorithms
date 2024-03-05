import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1062_가르침 {
	static List<String> STRS;
	static List<Character> CHS;
	static int MAX;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) - 5;
		
		if(K < 0) {
			System.out.println(0);
			return;
		}
		
		STRS = new ArrayList<>();
		CHS = new ArrayList<>();
		Set<Character> set = new HashSet<>();
		int result = 0;
		
		for(int i=0; i<N; ++i) {
			String str = br.readLine();
			str = str.substring(4, str.length()-4);
			str = str.replaceAll("[acint]", "");
			
			for(int j=0; j<str.length(); ++j) {
				set.add(str.charAt(j));
			}
			
			if(!str.equals("")) {
				STRS.add(str);
			} else ++result;
		}
		
		for (Character ch : set) {
			CHS.add(ch);
		}
		
		if(CHS.size() > K) {
			combination(0, CHS.size(), K, new boolean[CHS.size()]);			
		} else result += STRS.size();
		
		System.out.println(result + MAX);
	}
	
	private static void combination(int depth, int n, int r, boolean[] v) {
		if(r == 0) {
			int count = 0;
			for(int cur=0; cur<STRS.size(); ++cur) {
				String str = STRS.get(cur);
				int check = 0;
				
				for(int i=0; i<str.length(); ++i) {
					for(int j=0; j<v.length; ++j) {
						if(v[j] && CHS.get(j) == str.charAt(i)) {
							++check;
						}
					}
				}
				
				if(check == str.length()) {
					++count;
				}
			}
			
			MAX = Math.max(count, MAX);
			return;
		}
		
		if(depth == n) {
			return;
		}
		
		v[depth] = true;
		combination(depth+1, n, r-1, v);
		v[depth] = false;
		combination(depth+1, n, r, v);
	}

}