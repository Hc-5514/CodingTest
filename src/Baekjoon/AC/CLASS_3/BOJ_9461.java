/**
 * 문제 : 파도반 수열
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9461 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long[] d = new long[101];

		// 초기값
		d[0] = 1;
		d[1] = 1;
		d[2] = 1;
		d[3] = 2;
		d[4] = 2;

		for (int i = 5; i <= 100; i++) {
			d[i] = d[i - 1] + d[i - 5];
		}

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < T; tc++) {
			bw.write(d[Integer.parseInt(br.readLine().trim()) - 1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
