/**
 * 문제 : 더하기 사이클
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1110 {

	private static int getNum(int n) {
		if (n < 10) {
			return n * 10 + n;
		} else {
			return (n % 10) * 10 + (n / 10 + n % 10) % 10;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine().trim());

		int cnt = 1;
		int n = getNum(N);
		while (n != N) {
			n = getNum(n);
			cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
