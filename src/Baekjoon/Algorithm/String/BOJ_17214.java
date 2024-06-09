/**
 * 문제 : 다항 함수의 적분
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17214 {

	private static String func(String str) {
		StringBuilder sb = new StringBuilder();
		if (str.length() == 1) {
			if (!str.equals("1")) {
				sb.append(str);
			}
			sb.append("x");
		} else {
			StringTokenizer st = new StringTokenizer(str, "x");
			int n = Integer.parseInt(st.nextToken());
			int xLen = str.length() - String.valueOf(n).length();
			int result = n / (xLen + 1);
			if (result != 1) {
				sb.append(result);
			}
			for (int i = 0; i < xLen + 1; i++) {
				sb.append("x");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String oriStr = br.readLine();
		st = new StringTokenizer(oriStr, "+-", true);

		while (st.hasMoreTokens()) {
			String str = st.nextToken();
			if (str.equals("-")) {
				bw.write("-");
			} else if (str.equals("+")) {
				bw.write("+");
			} else if (str.equals("0")) {
				bw.write("W");
			} else {
				bw.write(func(str));
			}
		}

		if (!oriStr.equals("0")) {
			bw.write("+W");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
