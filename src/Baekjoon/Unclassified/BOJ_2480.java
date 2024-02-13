/**
 * 문제 : 주사위 세개
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2480 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int n3 = Integer.parseInt(st.nextToken());

		int result = 0;
		if (n1 == n2 && n2 == n3 && n3 == n1) {
			result = 10000 + n1 * 1000;
		} else if (n1 == n2 || n2 == n3) {
			result = 1000 + n2 * 100;
		} else if (n3 == n1) {
			result = 1000 + n1 * 100;
		} else {
			int max = n1;
			max = Math.max(max, n2);
			max = Math.max(max, n3);
			result = max * 100;
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
