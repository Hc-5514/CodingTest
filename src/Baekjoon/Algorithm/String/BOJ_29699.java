/**
 * 문제 : Welcome to SMUPC!
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_29699 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "WelcomeToSMUPC";
		int N = (Integer.parseInt(br.readLine()) - 1) % str.length();

		bw.write(str.charAt(N) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
