/**
 * 문제 : 성택이의 은밀한 비밀번호
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_25372 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (str.length() >= 6 && str.length() <= 9) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
