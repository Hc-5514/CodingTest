/**
 * 문제 : 자동완성
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_24883 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char ch = br.readLine().charAt(0);
		if (ch == 'N' || ch == 'n') {
			bw.write("Naver D2\n");
		} else {
			bw.write("Naver Whale\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
