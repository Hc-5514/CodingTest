/**
 * 문제 : Cupcake Party
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_24568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int R = Integer.parseInt(br.readLine().trim());
		int S = Integer.parseInt(br.readLine().trim());
		int result = (R * 8 + S * 3) - 28;

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
