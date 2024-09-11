/**
 * 문제 : 타노스
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_20310 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int cnt0 = 0;
		int cnt1 = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				cnt0++;
			} else {
				cnt1++;
			}
		}

		int cnt2 = 0;
		int cnt3 = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0' && cnt2 < cnt0 / 2) {
				bw.write(0 + "");
				cnt2++;
			}
			if (s.charAt(i) == '1') {
				if (cnt3 < cnt1 / 2) {
					cnt3++;
					continue;
				}
				bw.write(1 + "");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
