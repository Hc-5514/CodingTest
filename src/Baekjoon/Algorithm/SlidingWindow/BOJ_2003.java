/**
 * 문제: 수들의 합 2
 * 난이도: 실버 4
 * 메모리: 14412KB, 시간: 104ms
 * 풀이: 투 포인터
 */

package Baekjoon.Algorithm.SlidingWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 입력
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] nums = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int low = 0; // 투 포인터 (low, high)
		int high = 0;
		int cur = nums[low]; // 수열의 합
		int cnt = 0;
		while (high < n) {
			if (cur == m) {
				cnt++;
			}

			if (cur > m) {
				cur -= nums[low++];
			} else {
				cur += nums[++high];
			}
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
