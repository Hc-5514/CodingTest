/**
 * 문제 : 한수
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1065 {

	private static boolean func(int n) {
		String nStr = String.valueOf(n);
		int sub = Character.getNumericValue(nStr.charAt(1)) - Character.getNumericValue(nStr.charAt(0));
		for (int i = 1; i < nStr.length() - 1; i++) {
			if (sub != Character.getNumericValue(nStr.charAt(i + 1)) - Character.getNumericValue(nStr.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine().trim()); // (1 <= N <= 1,000)

		// 1 ~ 99: 한수
		if (N < 100) {
			bw.write(N + "\n");
		} else {
			int cnt = 99;
			// 100 ~ 110: 한수가 없다.
			for (int i = 111; i <= N; i++) {
				if (func(i)) {
					cnt++;
				}
			}
			bw.write(cnt + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
