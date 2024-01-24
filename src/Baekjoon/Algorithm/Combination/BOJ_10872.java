/**
 * 문제 : 팩토리얼
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Combination;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10872 {

	private static int[] factorials;

	private static void getFactorial(int n) {
		if (n < 2) {
			factorials[n] = 1;
		} else {
			factorials[n] = factorials[n - 1] * n;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine().trim());
		factorials = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			getFactorial(i);
		}

		bw.write(factorials[N] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
