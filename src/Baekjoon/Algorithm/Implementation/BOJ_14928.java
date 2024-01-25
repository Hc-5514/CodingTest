/**
 * 문제 : 큰 수 (BIG)
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_14928 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String nStr = br.readLine().trim();
		int rest = 0;
		for (int i = 0; i < nStr.length(); i++) {
			rest = ((rest * 10) + (nStr.charAt(i) - '0')) % 20000303;
		}

		bw.write(rest + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
