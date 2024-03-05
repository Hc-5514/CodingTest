/**
 * 문제 : 별 찍기 - 7
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2444 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i - 1; j++) {
				bw.write(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}

		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < N - i - 1; j++) {
				bw.write(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
