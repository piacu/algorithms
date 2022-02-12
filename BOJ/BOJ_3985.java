import java.util.Scanner;
/*
 * BOJ 3985. 롤 케이크
 */
public class BOJ_3985 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cakeLength = sc.nextInt();
		int humanNumber = sc.nextInt();
		int[] cake = new int[cakeLength + 1];// 인덱스 1부터 배열 시작인 테스트 케이스와 맞추기 위해 1 증가
		int[] audCount = new int[humanNumber + 1]; // 인덱스 1부터 배열 시작인 테스트 케이스와 맞추기 위해 1 증가
		int expected = 0, real = 0, tmp1 = 0, tmp2 = 0;

		for (int aud = 1; aud <= humanNumber; aud++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			for (int i = start; i <= end; i++) { // 케이크 조각 찜하기(방청객 번호)
				if (cake[i] == 0) {
					cake[i] = aud;
				}
			}

			if (end - start > tmp1) { // 가장 많은 조각을 받도록 예상되는 방청객
				tmp1 = end - start;
				expected = aud;
			}
		}

		for (int i = 0; i < cake.length; i++) { // 방청객 번호 당 받은 케이크 개수 입력
			audCount[cake[i]]++;
		}

		System.out.println(expected);

		for (int i = 1; i < audCount.length; i++) { // 실제로 가장 많은 조각을 받은 방청객 계산(0번인 방청객은 없으므로 1번 인덱스부터 시작)
			if (tmp2 < audCount[i]) {
				tmp2 = audCount[i];
				real = i;
			}
		}

		System.out.println(real);

		sc.close();
	}

}
