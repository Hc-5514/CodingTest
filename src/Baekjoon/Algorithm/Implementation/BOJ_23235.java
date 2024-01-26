/**
 * 문제 : The Fastest Sorting Algorithm In The World
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_23235 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = 0;

		while (!(br.readLine()).equals("0")) {
			cnt++;
		}

		for (int tc = 1; tc <= cnt; tc++) {
			bw.write("Case " + tc + ": Sorting... done!\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
