/**
 * 문제 : Larger Sport Facility
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_16099 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			BigInteger l1 = new BigInteger(st.nextToken());
			BigInteger w1 = new BigInteger(st.nextToken());
			BigInteger l2 = new BigInteger(st.nextToken());
			BigInteger w2 = new BigInteger(st.nextToken());

			BigInteger result1 = l1.multiply(w1);
			BigInteger result2 = l2.multiply(w2);

			if (result1.compareTo(result2) == 1) {
				bw.write("TelecomParisTech\n");
			} else if (result1.compareTo(result2) == 0) {
				bw.write("Tie\n");
			} else {
				bw.write("Eurecom\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
