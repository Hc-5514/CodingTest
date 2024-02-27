/**
 * 문제 : 인공지능 시계
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

public class BOJ_2530 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(br.readLine().trim());

		int total = 0;
		total += A * 60 * 60;
		total += B * 60;
		total += C;
		total += D;

		int h = (total / 3600) >= 24 ? (total / 3600) % 24 : (total / 3600);
		total %= 3600;
		int m = total / 60;
		int s = total % 60;

		bw.write(h + " " + m + " " + s);
		bw.flush();
		bw.close();
		br.close();
	}
}
