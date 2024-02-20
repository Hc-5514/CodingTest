/**
 * 문제 : 알파벳 개수
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String S = br.readLine();
		int[] alpha = new int[26];

		for (int i = 0; i < S.length(); i++) {
			alpha[S.charAt(i) - 97]++;
		}

		for (int i = 0; i < 26; i++) {
			bw.write(alpha[i] + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
