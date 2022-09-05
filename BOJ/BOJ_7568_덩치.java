import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_7568_덩치 {
	static class PersonInfo {
		int kg;
		int cm;
		int rank;

		public PersonInfo(int kg, int cm, int rank) {
			super();
			this.kg = kg;
			this.cm = cm;
			this.rank = rank;
		}
		
		@Override
		public String toString() {
			return "PersonInfo [kg=" + kg + ", cm=" + cm + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int people = Integer.parseInt(br.readLine());
		
		List<PersonInfo> plist = new ArrayList<>();
		
		for (int i = 0; i < people; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			plist.add(new PersonInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1));
		}
		
		for (int i = 0; i < plist.size(); i++) {
			for (int j = 0; j < plist.size(); j++) {
				if(plist.get(i).cm < plist.get(j).cm && plist.get(i).kg < plist.get(j).kg) {
					plist.get(i).rank++;
				}
			}
		}
		
		for (int i = 0; i < plist.size(); i++) {
			System.out.print(plist.get(i).rank+" ");
		}

	}

}
