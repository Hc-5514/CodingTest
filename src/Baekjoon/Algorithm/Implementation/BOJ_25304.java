/**
 * 문제 : 영수증
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

public class BOJ_25304 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int X = Integer.parseInt(br.readLine().trim()); // 총 금액
		int N = Integer.parseInt(br.readLine().trim()); // 물건 종류 수

		int sum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sum += a * b;
		}

		if (X == sum) {
			bw.write("Yes\n");
		} else {
			bw.write("No\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
