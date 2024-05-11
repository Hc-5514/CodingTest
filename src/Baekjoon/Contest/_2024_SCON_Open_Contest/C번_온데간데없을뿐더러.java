/**
 * 문제 : C번 - 온데간데없을뿐더러
 *
 * @author Hc-5514
 */

package Baekjoon.Contest._2024_SCON_Open_Contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class C번_온데간데없을뿐더러 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		long a = 0L;
		long b = 0L;

		int N = Integer.parseInt(br.readLine().trim());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n < 10) {
				a = a * 10 + n;
			} else {
				a = a * 100 + n;
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n < 10) {
				b = b * 10 + n;
			} else {
				b = b * 100 + n;
			}
		}

		long answer = a < b ? a : b;
		bw.write(answer + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
