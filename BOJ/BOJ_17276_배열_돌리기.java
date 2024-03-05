import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_17276_배열_돌리기 {
	static int[][] array;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int rad = Integer.parseInt(st.nextToken()) / 45;
			
			rad = (rad+8) % 8;
			array = new int[size][size];
			
			for (int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < size; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < rad; i++) {
				rotate(array, size/2);
			}
			
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					sb.append(array[i][j]+" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}

	}

	private static void rotate(int[][] arr, int mid) {
		int[][] tmpArr = new int[arr.length][arr.length];
		
		for (int i = 0; i < tmpArr.length; i++) {
			for (int j = 0; j < tmpArr.length; j++) {
				
				if(i == j) tmpArr[i][j] = arr[mid][j];
				else if(i == mid) tmpArr[i][j] = arr[arr.length-1-j][j];
				else if(j == mid) tmpArr[i][j] = arr[i][i];
				else if(i+j == arr.length-1) tmpArr[i][j] = arr[i][mid];
				else tmpArr[i][j] = arr[i][j];
				
			}
			
		}
		for (int i = 0; i < arr.length; i++) {
			System.arraycopy(tmpArr, 0, arr, 0, arr.length);
		}
	}

}