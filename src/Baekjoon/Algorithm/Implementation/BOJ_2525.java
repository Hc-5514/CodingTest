/**
 * 문제 : 오븐 시계
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

public class BOJ_2525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine().trim());

		int total = A * 60 + B + C;
		int h = (total / 60) % 24;
		int m = total % 60;

		bw.write(h + " " + m + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
