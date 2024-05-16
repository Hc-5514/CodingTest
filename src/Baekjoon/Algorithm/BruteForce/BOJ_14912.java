/**
 * 문제 : 숫자 빈도수
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int[] digits = new int[10];

		for (int i = 1; i <= n; i++) {
			int cur = i;
			while (cur >= 10) {
				digits[cur % 10]++;
				cur /= 10;
			}
			digits[cur]++;
		}

		bw.write(digits[d] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
