/**
 * 문제 : [S/W 문제해결 기본] 1일차 - View 
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.util.Scanner;

public class SWEA_D3_1206 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			// N: 건물 수, count: 조망권이 확보된 세대 수
			int N = sc.nextInt();
			int[] arr = new int[N];

			int count = 0;

			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();

			// 조망권이 확보된 세대 수 구하기
			// 0, 1, N-2, N-1 번째 건물은 높이가 0
			for (int i = 2; i < N - 2; i++) {

				int height1 = arr[i] - arr[i - 2];
				int height2 = arr[i] - arr[i - 1];
				int height3 = arr[i] - arr[i + 1];
				int height4 = arr[i] - arr[i + 2];

				// 좌우 2건물보다 더 높다면
				if (height1 > 0 && height2 > 0 && height3 > 0 && height4 > 0) {
					count += Math.min(Math.min(height1, height2), Math.min(height3, height4));
				}
			}

			System.out.printf("#%d %d\n", tc, count);
		}
	}

}
