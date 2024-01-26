/**
 * 문제 : An Easy-Peasy Problem
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

public class BOJ_30214 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		double s1 = Double.parseDouble(st.nextToken());
		double s2 = Double.parseDouble(st.nextToken());

		if (s1 >= s2 / 2) {
			bw.write("E");
		} else {
			bw.write("H");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
