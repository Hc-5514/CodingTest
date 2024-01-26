/**
 * 문제 : Arno's Sleep Schedule
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_29863 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a = Integer.parseInt(br.readLine().trim());
		if (a < 4) {
			a += 24;
		}
		int b = Integer.parseInt(br.readLine().trim()) + 24;

		bw.write((b - a) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
