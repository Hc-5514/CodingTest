/**
 * 문제 : 파스칼의 삼각형
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D2_2005 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int N;
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];

			// 파스칼의 삼각형 생성
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if (j == 0 || j == i)
						arr[i][j] = 1;
					else {
						arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
					}
				}
			}

			// 출력
			System.out.println("#" + tc);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

		}
	}

}
