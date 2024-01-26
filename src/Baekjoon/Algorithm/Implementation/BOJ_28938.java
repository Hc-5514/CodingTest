/**
 * 문제 : Конвейер
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

public class BOJ_28938 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine());

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(st.nextToken());
		}

		if (sum < 0) {
			bw.write("Left");
		} else if (sum == 0) {
			bw.write("Stay");
		} else {
			bw.write("Right");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
