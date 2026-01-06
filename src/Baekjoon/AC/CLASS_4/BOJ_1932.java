/**
 * 문제: 정수 삼각형
 * 난이도: 실버 1
 * 메모리: 24884KB, 시간: 188ms
 * 풀이: DP
 */

package Baekjoon.AC.CLASS_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1932 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine()); // 1 <= n <= 500
		int[][] triangle = new int[n][n];
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = triangle[0][0];

		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + triangle[i][0];
			dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
			for (int j = 1; j < i; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
			}
		}

		int result = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			result = Math.max(result, dp[n - 1][i]);
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}