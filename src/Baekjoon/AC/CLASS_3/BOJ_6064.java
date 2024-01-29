/**
 * 문제 : 카잉 달력
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_6064 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		f1:
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // (1 ≤ M ≤ 40,000)
			int N = Integer.parseInt(st.nextToken()); // (1 ≤ N ≤ 40,000)
			int x = Integer.parseInt(st.nextToken()); // (1 ≤ x ≤ M)
			int y = Integer.parseInt(st.nextToken()); // (1 ≤ y ≤ N)

			if (N == y) {
				y = 0;
			}

			for (int i = x; i <= N * M; i += M) {
				if (i % N == y) {
					bw.write(i + "\n");
					continue f1;
				}
			}

			bw.write("-1\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
