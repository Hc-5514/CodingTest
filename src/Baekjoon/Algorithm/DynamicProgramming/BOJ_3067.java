/**
 * 문제 : Coins
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_3067 {

	// 동전의 종류가 주어질 때 주어진 금액을 만드는 모든 방법을 세는 경우의 수 구하기

	// knapsack 베낭 문제

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine().trim()); // 동전의 종류 개수

			int[] coins = new int[n + 1];
			int[][] dp = new int[n + 1][10001];

			String[] str = br.readLine().split(" ");
			for (int i = 1; i <= n; i++) {
				coins[i] = Integer.parseInt(str[i - 1]);
				dp[i][coins[i]]++;
			}

			int m = Integer.parseInt(br.readLine().trim()); // 금액

			for (int i = 1; i <= n; i++) { // 동전의 종류
				for (int j = 1; j <= m; j++) { // 현재 금액
					dp[i][j] += dp[i - 1][j];
					if (coins[i] <= j) {
						dp[i][j] += dp[i][j - coins[i]];
					}
				}
			}

			bw.write(dp[n][m] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
