/**
 * 문제 : 세금
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_20492 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine().trim());

		int result1 = N / 100 * 78;
		int result2 = N / 100 * 80 + N / 100 * 20 / 100 * 78;

		bw.write(result1 + " " + result2 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
