/**
 * 문제 : 1, 2, 3 더하기 4
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_15989 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][] d = new int[10001][3];
		d[1][0] = 1;
		d[2][0] = 1;
		d[2][1] = 1;
		d[3][0] = 1;
		d[3][1] = 1;
		d[3][2] = 1;

		for (int i = 4; i <= 10000; i++) {
			d[i][0] = d[i - 1][0];
			d[i][1] = d[i - 2][0] + d[i - 2][1];
			d[i][2] = d[i - 3][0] + d[i - 3][1] + d[i - 3][2];
		}

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine().trim());
			bw.write((d[n][0] + d[n][1] + d[n][2]) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
