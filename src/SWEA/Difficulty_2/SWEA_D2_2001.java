/**
 * 문제 : 파리 퇴치
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.util.Scanner;

public class SWEA_D2_2001 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			// N x N 배열 만들기
			int N = sc.nextInt();
			int[][] arr = new int[N + 1][N + 1];

			int M = sc.nextInt();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// M x M 영역 최대 파리수 구하기
			int count = 0, max = 0;
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {

					// M x M 영역 합 구하기
					for (int k = 0; k < M; k++) {
						for (int l = 0; l < M; l++) {
							count += arr[i + k][j + l];
						}
					}

					if (count > max)
						max = count;

					count = 0;
				}

			}

			System.out.println("#" + tc + " " + max);
		}
	}

}
