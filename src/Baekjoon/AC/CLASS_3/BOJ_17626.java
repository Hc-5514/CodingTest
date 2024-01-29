/**
 * 문제 : Four Squares
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_17626 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine().trim());
		int[] d = new int[n + 2];
		Arrays.fill(d, 5);

		for (int i = 1; i <= n; i++) {
			int sqrtNum = (int)Math.sqrt(i);
			// 제곱수 확인
			if (i - (int)Math.pow(sqrtNum, 2) == 0) {
				d[i] = 1;
				d[i + 1] = 2;
				i++;
				continue;
			}

			for (int j = 1; j <= sqrtNum; j++) {
				d[i] = Math.min(d[i], d[i - j * j] + 1);
			}
		}

		bw.write(d[n] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
