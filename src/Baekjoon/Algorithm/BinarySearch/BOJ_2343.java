/**
 * 문제 : 기타 레슨
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2343 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] lesson = new int[N];
		int longestLesson = 0;
		for (int i = 0; i < N; i++) {
			lesson[i] = Integer.parseInt(st.nextToken());
			longestLesson = Math.max(longestLesson, lesson[i]);
		}

		int s = longestLesson;
		int e = 1000000;

		while (s <= e) {
			int m = (s + e) >> 1;
			int cnt = 0;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += lesson[i];
				if (sum > m) {
					sum = lesson[i];
					cnt++;
				}
			}
			if (sum != 0) {
				cnt++;
			}
			if (cnt > M) {
				s = m + 1;
			} else {
				e = m - 1;
			}
		}

		bw.write(s + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}