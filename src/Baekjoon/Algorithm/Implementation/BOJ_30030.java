/**
 * 문제 : 스위트콘 가격 구하기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_30030 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int B = Integer.parseInt(br.readLine().trim());

		bw.write(B / 11 * 10 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
