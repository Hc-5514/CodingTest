/**
 * 문제 : A와 B 2
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_12919 {

	private static StringBuilder s, t;
	private static boolean isPossible;

	private static StringBuilder sub(StringBuilder sb) {
		return new StringBuilder(sb.subSequence(0, sb.length() - 1));
	}

	private static StringBuilder reverse(StringBuilder sb) {
		return new StringBuilder(sb.reverse().subSequence(0, sb.length() - 1));
	}

	private static void func(StringBuilder sb) {
		if (isPossible) {
			return;
		}

		if (s.length() == sb.length()) {
			if (s.toString().equals(sb.toString())) {
				isPossible = true;
			}
			return;
		}

		if (sb.charAt(sb.length() - 1) == 'A') {
			func(sub(new StringBuilder(sb)));
		}

		if (new StringBuilder(sb).reverse().charAt(sb.length() - 1) == 'B') {
			func(reverse(new StringBuilder(sb)));
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		s = new StringBuilder(br.readLine());
		t = new StringBuilder(br.readLine());

		func(t);

		if (isPossible) {
			bw.write(1 + "\n");
		} else {
			bw.write(0 + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
