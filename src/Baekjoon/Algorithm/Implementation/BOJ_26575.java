/**
 * 문제 : Pups
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

public class BOJ_26575 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			double d = Double.parseDouble(st.nextToken());
			double f = Double.parseDouble(st.nextToken());
			double p = Double.parseDouble(st.nextToken());
			double result = d * f * p;
			System.out.printf("$%.2f\n", result);
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
