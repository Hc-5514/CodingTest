/**
 * 문제 : 알고리즘 수업 - 점근적 표기 1
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

public class BOJ_24313 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a1 = Integer.parseInt(st.nextToken());
		int a0 = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(br.readLine().trim());
		int n0 = Integer.parseInt(br.readLine().trim());

		if ((a1 * n0 + a0 <= c * n0) && a1 <= c) {
			bw.write("1\n");
		} else {
			bw.write("0\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
