/**
 * 문제 : 주식
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BOJ_11501 {

	private static int n;
	private static int[] info;

	private static long getMaxBenefit() {
		long result = 0;
		int cur = info[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (info[i] < cur) {
				result += (cur - info[i]);
			} else {
				cur = info[i];
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine().trim()); // testcase

		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine().trim()); // 날짜 수
			info = Stream.of(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray(); // 날짜 별 주가
			bw.write(getMaxBenefit() + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
