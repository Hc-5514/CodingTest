/**
 * 문제 : 母音を数える (Counting Vowels)
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_18409 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine().trim());
		String str = br.readLine();

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			char ch = str.charAt(i);
			if (ch == 'a' || ch == 'i' || ch == 'u' || ch == 'e' || ch == 'o') {
				cnt++;
			}
		}

		bw.write(cnt + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
