/**
 * 문제 : 등수 구하기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1205 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		Integer[] scores = new Integer[N];

		if (N == 0) {
			sb.append(1);
		} else {
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(scores, Collections.reverseOrder());

			if (N == P && scores[N - 1] >= score) {// N == P 라면, 랭킹 등록 못 할 수도 있음
				sb.append(-1);
			} else {
				for (int i = 0; i < N; i++) {
					if (score >= scores[i]) {
						sb.append(i + 1);
						break;
					}
				}
			}
		}

		if (sb.length() == 0) {
			bw.write((N + 1) + "\n");
		} else {
			bw.write(sb.toString());
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
