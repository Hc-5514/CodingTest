/**
 * 문제 : A+B
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

public class BOJ_26711 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		BigInteger a = new BigInteger(br.readLine());
		BigInteger b = new BigInteger(br.readLine());

		bw.write(a.add(b) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
