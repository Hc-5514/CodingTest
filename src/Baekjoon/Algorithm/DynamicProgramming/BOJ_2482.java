/**
 * 문제 : 색상환
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2482 {

	// 인접한 두 색을 동시에 사용하지 않는다.
	// N개의 색 중 인접한 두 색을 동시에 사용하지 않으면서, 서로 다른 K개의 색을 선택하는 경우의 수 구하기

	// 'i번째 칸을 색칠하는 경우' + 'i번째 칸을 색칠하지 않는 경우'로 나눠서 생각해야 한다.
	// 1) i번째 칸을 색칠하는 경우: 인접한 2칸을 칠 할 수 없고, 1칸은 이미 칠했다.
	// -> [N-3][K-1]
	// 2) i번째 칸을 색칠하지 않는 경우: i번째 칸을 제외한 칸 중 K개를 칠한다.
	// -> [N-1][K]
	// dp[N][K] = dp[N-3][K-1] + dp[N-1][K]

	private static final int MOD = 1_000_000_003;
	private static int N, K;
	private static int[][] dp;

	private static void init() {
		dp = new int[N + 1][K + 1];
		for (int i = 0; i <= N; i++) {
			dp[i][0] = 1; // N개의 색 중 0개를 뽑는 경우의 수는 1개
			dp[i][1] = i; // N개의 색 중 1개를 뽑는 경우의 수는 N개
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine().trim()); // (4 <= N <= 1,000)
		K = Integer.parseInt(br.readLine().trim()); // (1 <= K <= N)

		init();

		for (int i = 3; i <= N; i++) {
			for (int j = 2; j <= (i + 1) / 2 && j <= K; j++) {
				dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % MOD;
			}
		}

		long result = (dp[N - 3][K - 1] + dp[N - 1][K]) % MOD;

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
