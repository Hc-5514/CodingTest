/**
 * 문제 : 평균은 넘겠지
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_4344 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] students = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				students[i] = Integer.parseInt(st.nextToken());
				sum += students[i];
			}
			double avg = Math.round(sum / N);
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (students[i] > avg) {
					cnt++;
				}
			}
			System.out.printf("%.3f", cnt * 100000 / N / 1000.0);
			System.out.println("%");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
