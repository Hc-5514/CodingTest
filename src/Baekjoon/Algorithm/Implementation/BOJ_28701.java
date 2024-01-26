/**
 * 문제 : 세제곱의 합
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_28701 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine().trim());

		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += i;
		}

		bw.write(sum + "\n");
		bw.write((int)Math.pow(sum, 2) + "\n");

		sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += Math.pow(i, 3);
		}

		bw.write(sum + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
