/**
 * 문제 : 코딩은 체육과목 입니다
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_25314 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine().trim()) / 4;
		for (int i = 0; i < N; i++) {
			bw.write("long ");
		}
		bw.write("int\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
