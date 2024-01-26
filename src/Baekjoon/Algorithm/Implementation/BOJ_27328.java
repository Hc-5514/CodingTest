/**
 * 문제 : 三方比較 (Three-Way Comparison)
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_27328 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int A = Integer.parseInt(br.readLine().trim());
		int B = Integer.parseInt(br.readLine().trim());

		if (A < B) {
			bw.write("-1\n");
		} else if (A == B) {
			bw.write("0\n");
		} else {
			bw.write("1\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
