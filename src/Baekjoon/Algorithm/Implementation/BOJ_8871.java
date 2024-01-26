/**
 * 문제 : Zadanie próbne 2
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_8871 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine().trim());
		int result1 = (n + 1) * 2;
		int result2 = (n + 1) * 3;

		bw.write(result1 + " " + result2 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
