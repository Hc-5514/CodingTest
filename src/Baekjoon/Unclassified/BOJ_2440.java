/**
 * 문제 : 별 찍기 - 3
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2440 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine().trim());
		for (int i = N; i >= 1; i--) {
			for (int j = 0; j < i; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
