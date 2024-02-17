/**
 * 문제 : 평균 점수
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10039 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int sum = 0;
		for (int i = 0; i < 5; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			n = n < 40 ? 40 : n;
			sum += n;
		}

		bw.write(sum / 5 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
