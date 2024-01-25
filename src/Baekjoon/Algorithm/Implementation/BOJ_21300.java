/**
 * 문제 : Bottle Return
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_21300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int result = 0;
		for (int i = 0; i < 6; i++) {
			result += Integer.parseInt(st.nextToken());
		}

		bw.write(result * 5 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
