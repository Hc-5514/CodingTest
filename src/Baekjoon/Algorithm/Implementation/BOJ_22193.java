/**
 * 문제 : Multiply
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

public class BOJ_22193 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		br.readLine();
		BigInteger N = new BigInteger(br.readLine().trim());
		BigInteger M = new BigInteger(br.readLine().trim());

		bw.write(N.multiply(M) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
