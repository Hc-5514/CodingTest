/**
 * 문제 : 수익
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_4097 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		while (N != 0) {
			int[] revenue = new int[N];
			revenue[0] = Integer.parseInt(br.readLine().trim());
			int max = revenue[0];
			for (int i = 1; i < N; i++) {
				int P = Integer.parseInt(br.readLine().trim());
				revenue[i] = Math.max(revenue[i - 1] + P, P);
				max = Math.max(max, revenue[i]);
			}
			bw.write(max + "\n");
			N = Integer.parseInt(br.readLine());
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
