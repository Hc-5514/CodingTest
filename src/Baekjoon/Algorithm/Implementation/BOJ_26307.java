/**
 * 문제 : Correct
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

public class BOJ_26307 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int HH = Integer.parseInt(st.nextToken());
		int MM = Integer.parseInt(st.nextToken());
		int result = (HH * 60 + MM) - 540;

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
