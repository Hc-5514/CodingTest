/**
 * 문제 : 구간 합 구하기 4
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// N, M 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// N x N 배열 입력 받기

		// arrN의 값이 아래와 같은 경우
		// 1 2 3 4
		// 2 3 4 5
		// arrSum 값은 아래와 같이 저장한다.
		// 1 3 6 10
		// 3 8 15 24
		int[][] arrN = new int[N][N];
		int[][] arrSum = new int[N][N];

		// 1행 입력 받기
		st = new StringTokenizer(br.readLine());
		arrN[0][0] = arrSum[0][0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			arrN[0][i] = Integer.parseInt(st.nextToken());
			arrSum[0][i] = arrSum[0][i - 1] + arrN[0][i];
		}

		// 2행 ~ N행 입력받기
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {

				// arrN값 입력 받기
				arrN[i][j] = Integer.parseInt(st.nextToken());

				// 누적 합 arrSum에 저장하기
				if (j == 0) {
					arrSum[i][0] = arrSum[i - 1][0] + arrN[i][0];
				} else {
					arrSum[i][j] = arrSum[i - 1][j] + arrSum[i][j - 1] - arrSum[i - 1][j - 1] + arrN[i][j];
				}
			}
		}

		// M번 구간 합 구하기
		for (int tc = 1; tc <= M; tc++) {
			// (x1,y1) ~ (x2,y2) 구간 입력 받기
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;

			// 구간 합 구하기
			int sum = arrSum[x2][y2];
			if (x1 != 0)
				sum -= arrSum[x1 - 1][y2];
				
			if (y1 != 0)
				sum -= arrSum[x2][y1 - 1];
			if (x1 != 0 && y1 != 0)
				sum += arrSum[x1 - 1][y1 - 1];

			sb.append(sum).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

}
