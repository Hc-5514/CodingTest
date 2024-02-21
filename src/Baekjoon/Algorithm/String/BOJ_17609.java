/**
 * 문제 : 회문
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_17609 {

	private static int passCnt;
	private static String str;

	private static void checkPalindrome(int cnt, int l, int r) {
		// 일반 문자열
		if (cnt == 2) {
			return;
		}
		while (l < r) {
			// 유사 회문 검사
			if (str.charAt(l) != str.charAt(r)) {
				checkPalindrome(cnt + 1, l + 1, r);
				checkPalindrome(cnt + 1, l, r - 1);
				return;
			} else {
				l++;
				r--;
			}
		}
		passCnt = Math.min(passCnt, cnt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine().trim()); // T(1 ≤ T ≤ 30)
		for (int tc = 1; tc <= T; tc++) {
			str = br.readLine(); // 3 <= str.length() <= 100,000
			passCnt = 2;
			checkPalindrome(0, 0, str.length() - 1);
			bw.write(passCnt + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
