/**
 * 문제 : 벼락치기
 * 소요 시간 : 30분
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BOJ_14728 {

	// 단원 별 요구 시간이상 공부할 경우 점수를 얻을 수 있다.
	// 최대 공부 시간 t만큼 공부하여 얻을 수 있는 최대 점수 구하기

	// knapsack 배낭 문제

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int[][] info = new int[n][2]; // 시간, 점수

		for (int i = 0; i < n; i++) {
			info[i] = Stream.of(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		int[][] dp = new int[n + 1][t + 1];
		for (int i = 1; i <= n; i++) { // n번째 단원까지 탐색
			int curTime = info[i - 1][0];
			for (int j = 1; j <= t; j++) { // t시간까지 공부
				dp[i][j] = dp[i - 1][j];
				if (curTime <= j) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - curTime] + info[i - 1][1]);
				}
			}
		}

		bw.write(dp[n][t] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
