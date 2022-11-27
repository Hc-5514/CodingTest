/**
 * 문제 : [S/W 문제해결 기본] 2일차 - Sum
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1209 {

	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr;
		for (int tc = 1; tc <= 10; tc++) {

			int max = Integer.MIN_VALUE;
			int N = Integer.parseInt(br.readLine());
			int sum = 0, n;

			// 100 x 100 배열 입력 받기, 행의 최대값 구하기
			arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					n = Integer.parseInt(st.nextToken());
					arr[i][j] = n;
					sum += n;
				}
				max = Math.max(max, sum);
				sum = 0;
			}

			// 열의 최댓값 구하기
			sum = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					sum += arr[j][i];
				}
				max = Math.max(max, sum);
				sum = 0;
			}

			// 대각선 최댓값 구하기
			sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += arr[i][i];
			}
			max = Math.max(max, sum);

			sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += arr[i][99 - i];
			}
			max = Math.max(max, sum);

			sb.append("#" + tc + " " + max + "\n");
		}
		System.out.println(sb);
	}

}
