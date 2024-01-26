/**
 * 문제 : Shares
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

public class BOJ_3733 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}

			st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			bw.write((S / (N + 1)) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
