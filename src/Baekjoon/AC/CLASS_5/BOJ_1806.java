/**
 * 문제 : 부분합
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BOJ_1806 {

	// 연속된 수들의 부분합 중에서 그 합이 S 이상이 되는 것 중, 가장 짧은 길이 구하기
	// 만족하는 부분합이 없다면, 0출력

	// 투 포인터를 이용한 누적합 문제

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 10 <= N < 100,000
		int S = Integer.parseInt(st.nextToken()); // 0 < S <= 100,000,000

		int[] nums = Stream.of(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		// 투 포인터
		int minLen = 1_000_000;
		int left = 0;
		int sum = 0;

		for (int right = 0; right < N; right++) {
			sum += nums[right];

			while (left <= right && S <= sum - nums[left]) {
				sum -= nums[left++];
			}

			// 길이 최소값 갱신
			if (S <= sum) {
				minLen = Math.min(minLen, (right - left + 1));
			}
		}

		minLen = (minLen == 1_000_000) ? 0 : minLen; // 만족하는 부분합이 없다면 0출력
		bw.write(minLen + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

/*
	*** 반례 ***

	1) 답: 1
	5 10
	1 1 1 8 10

	2) 답: 10
	10 10
	1 1 1 1 1 1 1 1 1 1
 */