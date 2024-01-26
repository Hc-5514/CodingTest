/**
 * 문제 : Copier
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_26574 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine().trim());
			bw.write(num + " " + num + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
