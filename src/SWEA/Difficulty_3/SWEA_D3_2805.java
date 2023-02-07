/**
 * 문제 : 농작물 수확하기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D3_2805 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			// N: 농장의 크기
			int N = Integer.parseInt(br.readLine());
			int[][] aryFarm = new int[N][N];

			// 농장물 가치 입력 받기
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					aryFarm[i][j] = str.charAt(j) - '0';
				}
			}

			// 수익 구하기 - 삼각형을 상하 두 개로 분리해서 계산
			int sum = 0;

			// ▲ 영역 값 구하기
			int size = N / 2;
			for (int i = 0; i <= size; i++) {
				for (int j = size - i; j <= size + i; j++) {
					sum += aryFarm[i][j];
				}
			}

			// ▼ 영역 값 구하기
			for (int i = 0; i < size; i++) {
				for (int j = size - i; j <= size + i; j++) {
					sum += aryFarm[N - i - 1][j];
				}
			}

			sb.append(String.format("#%d %d\n", tc, sum));
		}

		System.out.println(sb.toString());
	}

}
