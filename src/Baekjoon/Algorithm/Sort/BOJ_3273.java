/**
 * 문제: 두 수의 합
 * 난이도: 실버 3
 * 메모리: 26072KB, 시간: 268ms
 * 풀이: 투 포인터
 */

package Baekjoon.Algorithm.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 입력
		int n = Integer.parseInt(br.readLine().trim());
		int[] nums = new int[n]; // 1, 2, ... , 100_000
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine().trim());

		// 정렬
		Arrays.sort(nums);

		// 투 포인터
		int cnt = 0;
		int start = 0;
		int end = n - 1;

		while (start < end) {
			int sum = nums[start] + nums[end];
			if (x < sum) {
				end--;
			} else {
				start++;
				if (x == sum) {
					cnt++;
				}
			}
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
