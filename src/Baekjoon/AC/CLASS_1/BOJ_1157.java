/**
 * 문제: 단어 공부
 * 난이도: 브론즈 1
 * 메모리: 20544KB, 시간: 160ms
 * 풀이: 문자열
 */

package Baekjoon.AC.CLASS_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inputString = br.readLine();
		int[] counts = new int[26];

		for (int i = 0; i < inputString.length(); i++) {
			char ch = inputString.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				counts[ch - 'A']++;
			} else {
				counts[ch - 'a']++;
			}
		}

		char answer = 'A';
		int cnt = counts[0];
		for (int i = 1; i < 26; i++) {
			if (counts[i] > cnt) {
				answer = (char)('A' + i);
				cnt = counts[i];
			} else if (counts[i] == cnt) {
				answer = '?';
			}
		}

		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
