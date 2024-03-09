/**
 * 문제 : 열 개씩 끊어 출력하기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11721 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		for (int i = 1; i <= str.length(); i++) {
			bw.write(str.charAt(i - 1));
			if (i % 10 == 0) {
				bw.write("\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
