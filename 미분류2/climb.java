import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class climb {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		long startTime = System.currentTimeMillis();
		for (int tc = 1; tc <= T; tc++) {
			int B = Integer.parseInt(br.readLine());
			long sum = 0;
			
			int[] arrayToNum = new int[10];
			int _B = B;
			int arrCounter = 0; // 배열이 어디까지 찼는지 알려주는 변수
			
			int z=0;
			while(_B != 0) {
				arrayToNum[z] = _B % 10;
				_B /= 10;
				arrCounter++;
				z++;
			}
			
			int prev = 0;
			int place = 1;
			
			for(int i=0; i<arrCounter; i++) {
				if(arrayToNum[i] >= 5) {
					sum += place + 2 * (prev * (arrayToNum[i] - 1));
				}else if(arrayToNum[i] >= 2) {
					sum += place + (prev * (arrayToNum[i] - 1));
				}else {
					sum += prev * arrayToNum[i];
				}
				
				prev = place + (prev * 9);
				place *= 10;
			}
					
//			ans.append("#").append(tc).append(" ").append(B - sum).append("\n");

			// TEST CODE
//			int count = 0;
//			while (B != 0) {
//				if (String.valueOf(B).contains("4") || String.valueOf(B).contains("5")
//						|| String.valueOf(B).contains("8")) {
//					// System.out.println(num);
//					B--;
//				} else {
//					// System.out.println("잘됐을경우"+num);
//					count++;
//					B--;
//				}
//			}
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
			System.out.println("elapsedTime : " + elapsedTime);
//			System.out.println("Verfy: " + count);
			System.out.println(sum);
		}

	}
}