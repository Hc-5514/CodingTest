/**
 * 문제: 공유기 설치
 * 난이도: 골드 4
 * 메모리: 29120KB, 시간: 264ms
 * 풀이: 매개 변수 탐색
 */

package Baekjoon.Algorithm.BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {

	private static int n, c;
	private static int[] coords;

	private static boolean check(int x) {
		int cnt = 1;
		int prev = coords[0];
		for (int i = 1; i < n; i++) {
			int cur = coords[i];
			if (cur - prev >= x) {
				prev = cur;
				cnt++;
			}
		}
		return cnt >= c;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 집 1개 -> 공유기 1개 설치 가능
		// 인접한 공유기 사이의 거리를 가능한 크게 하여 설치

		n = Integer.parseInt(st.nextToken()); // 집 개수, 2 <= n <= 200_000
		c = Integer.parseInt(st.nextToken()); // 공유기 개수, 2 <= c <= n
		coords = new int[n];

		for (int i = 0; i < n; i++) {
			coords[i] = Integer.parseInt(br.readLine()); // 집 좌표,  1 <= x <= 1_000_000_000
		}

		Arrays.sort(coords);

		int start = 0;
		int end = coords[n - 1] - coords[0];
		long ans = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2; // 공유기 사이 거리

			if (check(mid)) {
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
