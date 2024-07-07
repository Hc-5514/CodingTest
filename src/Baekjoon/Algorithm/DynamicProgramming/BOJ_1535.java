/**
 * 문제 : 안녕
 * 소요 시간 : 27분
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class BOJ_1535 {

	// 1~N번의 사람들에게 감사 인사를 한다.
	// i번 사람에게 인사를 하면 L[i] 체력을 잃고, J[i] 기쁨을 얻는다.
	// 인사는 중복으로 할 수 없다.
	// 시작 체력은 100, 기쁨은 0이며, 체력이 0이하가 되면 죽어서 기쁨을 느끼지 못한다.
	// 얻을 수 있는 최대 기쁨은?

	// knapsack 배낭 문제

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine().trim());
		int[] stamina = Stream.of(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int[] benefit = Stream.of(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int[][] dp = new int[n + 1][100]; // 체력은 1이상 이어야 한다.
		for (int i = 1; i <= n; i++) { // i번째 사람까지
			for (int j = 1; j < 100; j++) { // j번째 체력 소모까지
				dp[i][j] = dp[i - 1][j];
				// 필요 소모 체력 <= 현재 소모할 수 있는 체력
				if (stamina[i - 1] <= j) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stamina[i - 1]] + benefit[i - 1]);
				}
			}
		}

		bw.write(dp[n][99] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
