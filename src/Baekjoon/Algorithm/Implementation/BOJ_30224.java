/**
 * 문제 : Lucky 7
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_30224 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1 000 000 000
		String nStr = br.readLine().trim();
		boolean isTrue = false;

		for (int i = 0; i < nStr.length(); i++) {
			if (nStr.charAt(i) == '7') {
				isTrue = true;
				break;
			}
		}

		int n = Integer.parseInt(nStr);
		if (isTrue) {
			if (n % 7 == 0) {
				bw.write("3");
			} else {
				bw.write("2");
			}
		} else {
			if (n % 7 == 0) {
				bw.write("1");
			} else {
				bw.write("0");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
