/**
 * 문제 : Intercepting Information
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_26209 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean isSuccess = true;
		for (int i = 0; i < 8; i++) {
			int N = Integer.parseInt(st.nextToken());
			if (N == 9) {
				isSuccess = false;
			}
		}

		if (isSuccess) {
			bw.write("S\n");
		} else {
			bw.write("F\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
