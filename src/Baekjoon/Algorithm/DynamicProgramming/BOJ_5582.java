/**
 * 문제 : 공통 부분 문자열
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5582 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str1 = br.readLine();
		String str2 = br.readLine();

		int[][] len = new int[str1.length() + 1][str2.length() + 1];
		int maxLen = 0;

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					len[i][j] = len[i - 1][j - 1] + 1;
					maxLen = Math.max(maxLen, len[i][j]);
				}
			}
		}

		bw.write(maxLen + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
