/**
 * 문제 : 스케이트 연습
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

public class BOJ_28324 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim());
		long[] scores = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			scores[i] = Long.parseLong(st.nextToken());
		}

		long pre = 1;
		long result = 1;
		for (int i = N - 2; i >= 0; i--) {
			pre = pre < scores[i] ? pre + 1 : scores[i];
			result += pre;
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
