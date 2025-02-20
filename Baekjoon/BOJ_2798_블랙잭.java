import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cardCnt = Integer.parseInt(st.nextToken());
		int targetNum = Integer.parseInt(st.nextToken());
		int[] cards = new int[cardCnt];
		int maxNum = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < cards.length; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				for (int k = 0; k < cards.length; k++) {
					if(cards[i] == cards[j] || cards[j] == cards[k] || cards[k] == cards[i]) {
						continue;
					}
					int sumCards = cards[i] + cards[j] + cards[k];
					
					if(targetNum - sumCards >= 0 && maxNum < sumCards) {
//						System.out.println("i, j, k : "+cards[i]+" "+cards[j]+" "+cards[k]+" sum : "+sumCards);
						maxNum = sumCards;
					}
				}
			}
		}
		
		System.out.println(maxNum);

	}

}
