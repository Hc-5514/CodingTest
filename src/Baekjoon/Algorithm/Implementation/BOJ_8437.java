/**
 * 문제 : Julka
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

public class BOJ_8437 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		BigInteger n = new BigInteger(br.readLine().trim());
		BigInteger sub = new BigInteger(br.readLine().trim());

		BigInteger ans2 = (n.subtract(sub)).divide(BigInteger.valueOf(2));
		BigInteger ans1 = ans2.add(sub);

		bw.write(ans1 + "\n" + ans2 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
