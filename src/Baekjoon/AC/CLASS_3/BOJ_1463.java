/**
 * 문제: 1로 만들기
 * 난이도: 실버 3
 * 메모리: 15836KB, 시간: 104ms
 * 풀이: DP
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_1463 {

	private static final int INF = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 3개의 연산을 사용해서 1을 만들 때, 연산 사용 횟수 최솟값 구하기

		int x = Integer.parseInt(br.readLine()); // 1 <= x <= 1_000_000
		int[] dp = new int[x + 1];

		Arrays.fill(dp, INF);
		dp[1] = 0;

		// Bottom-up
		for (int i = 2; i <= x; i++) {
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}

		bw.write(dp[x] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}