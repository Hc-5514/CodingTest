/**
 * 문제 : Pyramids
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5341 {

	private static int getSum(int n) {
		return n * (n + 1) / 2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine().trim());
		while (n != 0) {
			bw.write(getSum(n) + "\n");
			n = Integer.parseInt(br.readLine().trim());
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
