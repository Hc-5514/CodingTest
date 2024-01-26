/**
 * 문제 : Киноманы
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

public class BOJ_28927 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int t1 = Integer.parseInt(st.nextToken());
		int e1 = Integer.parseInt(st.nextToken());
		int f1 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int t2 = Integer.parseInt(st.nextToken());
		int e2 = Integer.parseInt(st.nextToken());
		int f2 = Integer.parseInt(st.nextToken());

		int result1 = t1 * 3 + e1 * 20 + f1 * 120;
		int result2 = t2 * 3 + e2 * 20 + f2 * 120;

		if (result1 > result2) {
			bw.write("Max");
		} else if (result1 == result2) {
			bw.write("Draw");
		} else {
			bw.write("Mel");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
