/**
 * 문제: 가장 긴 증가하는 부분 수열
 * 난이도: 실버 2
 * 메모리: 12524KB, 시간: 92ms
 * 풀이: DP
 */

package Baekjoon.AC.CLASS_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * LIS 알고리즘 (Longest Increasing Subsequence)
 * 기본적으로 DP를 이용한다.
 * 이 문제는 O(N²) 풀이법을 이용했다.
 */

public class BOJ_11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine()); // 1 <= n <= 1_000
		int[] nums = new int[n];
		int[] dp = new int[n]; // i 번째 원소를 포함하여 가장 긴 증가하는 부분 수열 길이

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken()); // 1 <= nums[i] <= 1_000
			dp[i] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			result = Math.max(result, dp[i]);
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}