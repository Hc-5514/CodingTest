/**
 * 문제 : A와 B
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_12904 {

	private static StringBuilder S, T;
	private static boolean isPossible;

	private static void make(StringBuilder s) {
		if (s.length() <= S.length()) {
			if (S.toString().equals(s.toString())) {
				isPossible = true;
			}
			return;
		}

		if (isPossible) {
			return;
		}

		if (s.charAt(s.length() - 1) == 'A') {
			make(add(new StringBuilder(s)));
		}

		if (s.charAt(s.length() - 1) == 'B') {
			make(reverse(new StringBuilder(s)));
		}
	}

	private static StringBuilder add(StringBuilder s) {
		return s.delete(s.length() - 1, s.length());
	}

	private static StringBuilder reverse(StringBuilder s) {
		return s.delete(s.length() - 1, s.length()).reverse();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		S = new StringBuilder(br.readLine());
		T = new StringBuilder(br.readLine());
		isPossible = false;

		make(T);

		if (isPossible) {
			bw.write("1\n");
		} else {
			bw.write("0\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
