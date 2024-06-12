/**
 * 문제 : Secret Location
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5340 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] len = new int[6];
		for (int i = 0; i < 6; i++) {
			String str = br.readLine();
			len[i] = str.charAt(str.length() - 1) == ' ' ? str.length() - 1 : str.length();
		}

		bw.write("Latitude " + len[0] + ":" + len[1] + ":" + len[2] + "\n");
		bw.write("Longitude " + len[3] + ":" + len[4] + ":" + len[5]);

		bw.flush();
		bw.close();
		br.close();
	}
}
