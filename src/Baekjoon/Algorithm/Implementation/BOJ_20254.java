/**
 * 문제 : Site Score
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

public class BOJ_20254 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int UR = Integer.parseInt(st.nextToken());
		int TR = Integer.parseInt(st.nextToken());
		int UO = Integer.parseInt(st.nextToken());
		int TO = Integer.parseInt(st.nextToken());
		int result = UR * 56 + TR * 24 + UO * 14 + TO * 6;

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
