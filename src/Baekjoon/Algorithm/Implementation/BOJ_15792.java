/**
 * 문제 : A/B - 2
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class BOJ_15792 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		BigDecimal A = new BigDecimal(st.nextToken());
		BigDecimal B = new BigDecimal(st.nextToken());
		bw.write(A.divide(B, 1000, RoundingMode.HALF_UP) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
