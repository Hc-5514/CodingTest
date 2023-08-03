/**
 * 문제 : 잠수함식별
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.*;

public class BOJ_2671{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		String answer = str.matches("(100+1+|01)+") ? "SUBMARINE" : "NOISE";

		bw.write(answer);
		bw.flush();
		bw.close();
		br.close();
	}
}