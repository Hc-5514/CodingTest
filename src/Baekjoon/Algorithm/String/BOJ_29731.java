/**
 * 문제 : 2033년 밈 투표
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_29731 {

	private static final String[] strings = {"Never gonna give you up", "Never gonna let you down",
		"Never gonna run around and desert you", "Never gonna make you cry", "Never gonna say goodbye",
		"Never gonna tell a lie and hurt you", "Never gonna stop"};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean isFalse = false;
		int N = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int cnt = 0;
			for (int j = 0; j < strings.length; j++) {
				if (str.equals(strings[j])) {
					cnt++;
				}
			}
			if (cnt == 0) {
				isFalse = true;
				break;
			}
		}

		if (isFalse) {
			bw.write("Yes");
		} else {
			bw.write("No");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
