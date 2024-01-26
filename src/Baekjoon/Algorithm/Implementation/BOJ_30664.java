/**
 * 문제 : Loteria Falha
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

public class BOJ_30664 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String nStr = "";
		while (!(nStr = br.readLine()).equals("0")) {
			BigInteger n = new BigInteger(nStr);

			if (n.mod(new BigInteger("42")) == BigInteger.ZERO) {
				bw.write("PREMIADO\n");
			} else {
				bw.write("TENTE NOVAMENTE\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
