/**
 * 문제 : Football Scoring
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

public class BOJ_24736 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			int result = 0;
			result += Integer.parseInt(st.nextToken()) * 6;
			result += Integer.parseInt(st.nextToken()) * 3;
			result += Integer.parseInt(st.nextToken()) * 2;
			result += Integer.parseInt(st.nextToken()) * 1;
			result += Integer.parseInt(st.nextToken()) * 2;
			bw.write(result + " ");
		}

		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
