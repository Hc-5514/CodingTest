/**
 * 문제 : 최대 합 순서쌍의 개수
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.PrefixSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_30646 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim());
		long[] nums = new long[N + 1];
		Map<Integer, Index> map = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			// 누적합 저장
			nums[i] = nums[i - 1] + num;
			// 순서쌍 위치 저장
			if (map.containsKey(num)) {
				map.get(num).setSE(i, i);
			} else {
				map.put(num, new Index(i, i));
			}
		}

		// 순서쌍 최대합 구하기
		long maxSum = 0;
		int cnt = 0;
		for (Index index : map.values()) {
			long sum = nums[index.e] - nums[index.s - 1];
			if (maxSum < sum) {
				maxSum = sum;
				cnt = 1;
			} else if (maxSum == sum) {
				cnt++;
			}
		}

		bw.write(maxSum + " " + cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static class Index {
		int s;
		int e;

		public Index(int s, int e) {
			this.s = s;
			this.e = e;
		}

		private void setSE(int s, int e) {
			this.s = Math.min(this.s, s);
			this.e = Math.max(this.e, e);
		}
	}
}
